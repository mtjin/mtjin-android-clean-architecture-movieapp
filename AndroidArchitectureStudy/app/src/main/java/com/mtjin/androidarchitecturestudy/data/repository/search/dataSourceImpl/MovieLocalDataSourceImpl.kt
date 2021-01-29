package com.mtjin.androidarchitecturestudy.data.repository.search.dataSourceImpl

import com.mtjin.androidarchitecturestudy.data.db.MovieDao
import com.mtjin.androidarchitecturestudy.data.model.search.MovieEntity
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSource.MovieLocalDataSource
import io.reactivex.Completable
import io.reactivex.Single

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override fun insertMovies(movies: List<MovieEntity>): Completable =
        movieDao.insertMovies(movies)

    override fun getAllMovies(): Single<List<MovieEntity>> = movieDao.getAllMovies()

    override fun getSearchMovies(title: String): Single<List<MovieEntity>> =
        movieDao.getMoviesByTitle(title)

    override fun deleteAllMovies(): Completable = movieDao.deleteAllMovies()

}