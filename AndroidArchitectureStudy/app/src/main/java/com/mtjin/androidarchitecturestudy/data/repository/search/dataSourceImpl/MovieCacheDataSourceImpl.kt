package com.mtjin.androidarchitecturestudy.data.repository.search.dataSourceImpl

import com.mtjin.androidarchitecturestudy.data.model.search.Movie
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}