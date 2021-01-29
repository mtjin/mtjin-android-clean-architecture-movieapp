package com.mtjin.androidarchitecturestudy.data.repository.search.remote

import com.mtjin.androidarchitecturestudy.data.api.ApiInterface
import com.mtjin.androidarchitecturestudy.data.model.search.MovieResponse
import io.reactivex.Single


class MovieRemoteDataSourceImpl(private val apiInterface: ApiInterface) :
    MovieRemoteDataSource {
    override fun getSearchMovies(query: String, start: Int): Single<MovieResponse> {
        return apiInterface.getSearchMovie(query, start)
    }
}