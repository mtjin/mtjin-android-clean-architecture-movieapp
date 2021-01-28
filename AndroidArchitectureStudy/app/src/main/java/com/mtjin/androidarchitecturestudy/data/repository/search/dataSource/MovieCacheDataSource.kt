package com.mtjin.androidarchitecturestudy.data.repository.search.dataSource

import com.mtjin.androidarchitecturestudy.data.model.search.Movie

interface MovieCacheDataSource {
    fun getMoviesFromCache(): List<Movie>
    fun saveMoviesToCache(movies: List<Movie>)
}