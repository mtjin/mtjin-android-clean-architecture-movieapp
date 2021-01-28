package com.mtjin.androidarchitecturestudy.data.repository.search.dataSourceImpl

import android.util.Log
import com.mtjin.androidarchitecturestudy.data.api.ApiInterface
import com.mtjin.androidarchitecturestudy.data.model.search.MovieResponse
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSource.MovieRemoteDataSource
import io.reactivex.Single


class MovieRemoteDataSourceImpl(private val apiInterface: ApiInterface) :
    MovieRemoteDataSource {
    override fun getSearchMovies(query: String, start: Int): Single<MovieResponse> {
        Log.d("EEEEEE", "사이즈 -> " + start)
        return apiInterface.getSearchMovie(query, start)
    }
}