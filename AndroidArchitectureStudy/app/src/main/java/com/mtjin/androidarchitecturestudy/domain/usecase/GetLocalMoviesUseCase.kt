package com.mtjin.androidarchitecturestudy.domain.usecase

import com.mtjin.androidarchitecturestudy.domain.model.search.Movie
import com.mtjin.androidarchitecturestudy.domain.repository.MovieRepository
import io.reactivex.Flowable

class GetLocalMoviesUseCase(private val repository: MovieRepository) {
    fun execute(
        query: String
    ): Flowable<List<Movie>> = repository.getSearchMovies(query)

}