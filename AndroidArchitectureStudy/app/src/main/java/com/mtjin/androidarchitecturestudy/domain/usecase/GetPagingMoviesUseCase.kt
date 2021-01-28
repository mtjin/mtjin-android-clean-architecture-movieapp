package com.mtjin.androidarchitecturestudy.domain.usecase

import com.mtjin.androidarchitecturestudy.data.model.search.Movie
import com.mtjin.androidarchitecturestudy.domain.repository.MovieRepository
import io.reactivex.Single

class GetPagingMoviesUseCase(private val repository: MovieRepository) {
    fun execute(
        query: String,
        offset: Int
    ): Single<List<Movie>> = repository.getPagingMovies(query, offset)
}