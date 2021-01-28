package com.mtjin.androidarchitecturestudy.data.repository.search.dataSource

import com.mtjin.androidarchitecturestudy.data.model.search.MovieResponse
import io.reactivex.Single

interface MovieRemoteDataSource {
    fun getSearchMovies(
        query: String,
        start: Int = 1
    ): Single<MovieResponse>
}