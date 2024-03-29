package com.mtjin.data.repository.search.remote

import com.mtjin.data.api.ApiInterface
import com.mtjin.data.model.search.MovieResponse
import io.reactivex.Single
import javax.inject.Inject


class MovieRemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiInterface) :
    MovieRemoteDataSource {
    override fun getSearchMovies(query: String, start: Int): Single<MovieResponse> {
        return apiInterface.getSearchMovie(query, start)
    }
}