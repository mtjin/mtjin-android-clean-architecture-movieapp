package com.mtjin.androidarchitecturestudy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mtjin.androidarchitecturestudy.data.model.search.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}