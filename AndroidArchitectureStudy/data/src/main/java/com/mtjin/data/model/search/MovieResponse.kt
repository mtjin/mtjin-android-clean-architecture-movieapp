package com.mtjin.data.model.search


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("display")
    val display: Int,
    @SerializedName("items")
    val movies: List<MovieEntity>,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String,
    @SerializedName("start")
    val start: Int,
    @SerializedName("total")
    val total: Int
)