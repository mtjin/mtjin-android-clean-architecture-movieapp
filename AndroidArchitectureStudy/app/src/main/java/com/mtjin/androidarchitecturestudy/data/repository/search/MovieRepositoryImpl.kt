package com.mtjin.androidarchitecturestudy.data.repository.search

import com.mtjin.androidarchitecturestudy.data.model.search.Movie
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSource.MovieCacheDataSource
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSource.MovieLocalDataSource
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSource.MovieRemoteDataSource
import com.mtjin.androidarchitecturestudy.domain.repository.MovieRepository
import io.reactivex.Flowable
import io.reactivex.Single

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override fun getSearchMovies(query: String): Flowable<List<Movie>> {
        return movieLocalDataSource.getSearchMovies(query)
            .onErrorReturn { listOf() }
            .flatMapPublisher { localMovies ->
                if (localMovies.isEmpty()) {
                    getRemoteSearchMovies(query)
                        .toFlowable()
                        .onErrorReturn { listOf() }
                } else {
                    val cached = Single.just(movieCacheDataSource.getMoviesFromCache()) // 캐시
                    val local = Single.just(localMovies) // 로컬 DB
                    val remote = getRemoteSearchMovies(query) // 서버 API
                        .onErrorResumeNext { local }
                    Single.concat(cached, local, remote) // 순서대로 불러옴
                }
            }
    }


    override fun getRemoteSearchMovies(
        query: String
    ): Single<List<Movie>> {
        return movieRemoteDataSource.getSearchMovies(query)
            .flatMap {
                movieCacheDataSource.saveMoviesToCache(it.movies) //캐싱 저장
                movieLocalDataSource.insertMovies(it.movies)
                    .andThen(Single.just(it.movies))
            }
    }

    override fun getPagingMovies(
        query: String,
        offset: Int
    ): Single<List<Movie>> {
        return movieRemoteDataSource.getSearchMovies(query, offset).flatMap {
            if (it.movies.isEmpty()) {
                Single.error(IllegalStateException("Last Page"))
            } else {
                if (offset != it.start) {
                    Single.error(IllegalStateException("Last Page"))
                } else {
                    val cachedMovies =
                        movieCacheDataSource.getMoviesFromCache() as MutableList<Movie>
                    cachedMovies.addAll(it.movies)
                    movieCacheDataSource.saveMoviesToCache(cachedMovies) //캐싱 저장
                    movieLocalDataSource.insertMovies(it.movies)
                        .andThen(Single.just(it.movies))
                }
            }
        }
    }
}