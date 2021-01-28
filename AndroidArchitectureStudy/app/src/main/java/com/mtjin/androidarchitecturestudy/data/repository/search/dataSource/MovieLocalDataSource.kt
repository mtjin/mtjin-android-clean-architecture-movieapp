package com.mtjin.androidarchitecturestudy.data.repository.search.dataSource

import com.mtjin.androidarchitecturestudy.data.model.search.Movie
import io.reactivex.Completable
import io.reactivex.Single

interface MovieLocalDataSource {
    fun insertMovies(movies: List<Movie>): Completable
    fun getAllMovies(): Single<List<Movie>>
    fun getSearchMovies(title: String): Single<List<Movie>>
    fun deleteAllMovies(): Completable
}