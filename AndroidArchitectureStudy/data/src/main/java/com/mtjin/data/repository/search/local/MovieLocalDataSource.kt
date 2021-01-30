package com.mtjin.data.repository.search.local

import com.mtjin.data.model.search.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

interface MovieLocalDataSource {
    fun insertMovies(movies: List<MovieEntity>): Completable
    fun getAllMovies(): Single<List<MovieEntity>>
    fun getSearchMovies(title: String): Single<List<MovieEntity>>
    fun deleteAllMovies(): Completable
}