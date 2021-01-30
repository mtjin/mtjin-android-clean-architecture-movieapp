package com.mtjin.androidarchitecturestudy.data.repository.search.local

import com.mtjin.androidarchitecturestudy.data.model.search.MovieEntity
import com.mtjin.androidarchitecturestudy.domain.model.search.Movie
import io.reactivex.Completable
import io.reactivex.Single

interface MovieLocalDataSource {
    fun insertMovies(movies: List<MovieEntity>): Completable
    fun getAllMovies(): Single<List<MovieEntity>>
    fun getSearchMovies(title: String): Single<List<MovieEntity>>
    fun deleteAllMovies(): Completable
}