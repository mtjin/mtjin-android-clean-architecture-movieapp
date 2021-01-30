package com.mtjin.data.repository.search

import com.mtjin.data.mapper.mapperToMovie
import com.mtjin.data.repository.search.local.MovieLocalDataSource
import com.mtjin.data.repository.search.remote.MovieRemoteDataSource
import com.mtjin.data.utils.LAST_PAGE
import com.mtjin.data.utils.NO_DATA_FROM_LOCAL_DB
import com.mtjin.domain.model.search.Movie
import com.mtjin.domain.repository.MovieRepository
import io.reactivex.Flowable
import io.reactivex.Single

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {

    //첫 영화검색
    override fun getSearchMovies(query: String): Flowable<List<Movie>> {
        return movieLocalDataSource.getSearchMovies(query)
            .onErrorReturn { listOf() }
            .flatMapPublisher { localMovies ->
                if (localMovies.isEmpty()) {
                    getRemoteSearchMovies(query)
                        .toFlowable()
                        .onErrorReturn { listOf() }
                } else {
                    val local = Single.just(mapperToMovie(localMovies)) // 로컬 DB
                    val remote = getRemoteSearchMovies(query) // 서버 API
                        .onErrorResumeNext { local }
                    Single.concat(local, remote) // 순서대로 불러옴
                }
            }
    }

    //인터넷이 끊킨 경우 로컬디비에서 검색
    override fun getLocalSearchMovies(query: String): Flowable<List<Movie>> {
        return movieLocalDataSource.getSearchMovies(query)
            .onErrorReturn { listOf() }
            .flatMapPublisher { cachedMovies ->
                if (cachedMovies.isEmpty()) {
                    Flowable.error(IllegalStateException(NO_DATA_FROM_LOCAL_DB))
                } else {
                    Flowable.just(mapperToMovie(cachedMovies))
                }
            }
    }

    // 서버 DB 영화검색 요청
    override fun getRemoteSearchMovies(
        query: String
    ): Single<List<Movie>> {
        return movieRemoteDataSource.getSearchMovies(query)
            .flatMap {
                movieLocalDataSource.insertMovies(it.movies)
                    .andThen(Single.just(mapperToMovie(it.movies)))
            }
    }

    //영화 검색 후 스크롤 내리면 영화 더 불러오기
    override fun getPagingMovies(
        query: String,
        offset: Int
    ): Single<List<Movie>> {
        return movieRemoteDataSource.getSearchMovies(query, offset).flatMap {
            if (it.movies.isEmpty()) {
                Single.error(IllegalStateException(LAST_PAGE))
            } else {
                if (offset != it.start) {
                    Single.error(IllegalStateException(LAST_PAGE))
                } else {
                    movieLocalDataSource.insertMovies(it.movies)
                        .andThen(Single.just(mapperToMovie(it.movies)))
                }
            }
        }
    }

}