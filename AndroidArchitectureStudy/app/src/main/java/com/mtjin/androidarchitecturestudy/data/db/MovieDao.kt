package com.mtjin.androidarchitecturestudy.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mtjin.androidarchitecturestudy.data.model.search.Movie
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MovieDao {

    @Insert(onConflict = REPLACE)
    fun insertMovies(movies: List<Movie>): Completable

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Single<List<Movie>>

    @Query("SELECT * FROM movie WHERE title LIKE '%' || :title || '%'")
    fun getMoviesByTitle(title: String): Single<List<Movie>>

    @Query("DELETE FROM movie")
    fun deleteAllMovies(): Completable
}