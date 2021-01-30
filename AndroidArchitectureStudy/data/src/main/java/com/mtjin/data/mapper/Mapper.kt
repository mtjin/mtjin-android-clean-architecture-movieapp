package com.mtjin.data.mapper

import com.mtjin.data.model.search.MovieEntity
import com.mtjin.domain.model.search.Movie

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

// 이 프로젝트에서는 Domain -> Data 레이어로 모델클래스를 매개변수로 전송하는 일이 없어서 사용은안한다
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