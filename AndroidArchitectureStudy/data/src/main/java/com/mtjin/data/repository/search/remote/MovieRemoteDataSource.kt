package com.mtjin.data.repository.search.remote

import com.mtjin.data.model.search.MovieResponse
import io.reactivex.Single

interface MovieRemoteDataSource {
    fun getSearchMovies(
        query: String,
        start: Int = 1
    ): Single<MovieResponse>
}