package com.mtjin.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mtjin.data.model.search.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MovieDao {

    @Insert(onConflict = REPLACE)
    fun insertMovies(movies: List<MovieEntity>): Completable

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Single<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE title LIKE '%' || :title || '%'")
    fun getMoviesByTitle(title: String): Single<List<MovieEntity>>

    @Query("DELETE FROM movie")
    fun deleteAllMovies(): Completable
}