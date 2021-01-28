package com.mtjin.androidarchitecturestudy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mtjin.androidarchitecturestudy.data.model.search.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}