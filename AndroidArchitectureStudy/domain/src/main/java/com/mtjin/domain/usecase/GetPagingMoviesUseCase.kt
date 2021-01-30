package com.mtjin.domain.usecase

import com.mtjin.domain.model.search.Movie
import com.mtjin.domain.repository.MovieRepository
import io.reactivex.Single

class GetPagingMoviesUseCase(private val repository: MovieRepository) {
    fun execute(
        query: String,
        offset: Int
    ): Single<List<Movie>> = repository.getPagingMovies(query, offset)
}