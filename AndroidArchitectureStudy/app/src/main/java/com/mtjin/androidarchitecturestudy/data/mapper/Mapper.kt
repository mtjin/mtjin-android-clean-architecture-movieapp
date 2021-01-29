package com.mtjin.androidarchitecturestudy.data.mapper

import com.mtjin.androidarchitecturestudy.data.model.search.MovieEntity
import com.mtjin.androidarchitecturestudy.domain.model.search.Movie


fun mapperToMovie(movies: List<MovieEntity>): List<Movie> {
    return movies.toList().map {
        Movie(
            it.actor,
            it.director,
            it.image,
            it.link,
            it.pubDate,
            it.subtitle,
            it.title,
            it.userRating
        )
    }
}

// 이 프로젝트에서는 Domain -> Data 레이어로 리스트를 저장하는 로직은 없어서 사용 안함
fun mapperToMovieEntity(movies: List<Movie>): List<MovieEntity> {
    return movies.toList().map {
        MovieEntity(
            it.actor,
            it.director,
            it.image,
            it.link,
            it.pubDate,
            it.subtitle,
            it.title,
            it.userRating
        )
    }
}