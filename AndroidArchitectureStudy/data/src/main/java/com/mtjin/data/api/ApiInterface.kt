package com.mtjin.data.api

import com.mtjin.data.model.search.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    // query : 검색어, start : 시작, display : 갖고올개수
    @GET("v1/search/movie.json")
    fun getSearchMovie(
        @Query("query") query: String,
        @Query("start") start: Int = 1,
        @Query("display") display: Int = 15
    ): Single<MovieResponse>
}