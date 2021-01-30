package com.mtjin.domain.repository

import com.mtjin.domain.model.search.Movie
import io.reactivex.Flowable
import io.reactivex.Single

interface MovieRepository {
    fun getSearchMovies(
        query: String
    ): Flowable<List<Movie>>

    fun getLocalSearchMovies(
        query: String
    ): Flowable<List<Movie>>

    fun getRemoteSearchMovies(
        query: String
    ): Single<List<Movie>>

    fun getPagingMovies(
        query: String,
        offset: Int
    ): Single<List<Movie>>
}