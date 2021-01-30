package com.mtjin.domain.usecase

import com.mtjin.domain.model.search.Movie
import com.mtjin.domain.repository.MovieRepository
import io.reactivex.Flowable

class GetLocalMoviesUseCase(private val repository: MovieRepository) {
    fun execute(
        query: String
    ): Flowable<List<Movie>> = repository.getSearchMovies(query)

}