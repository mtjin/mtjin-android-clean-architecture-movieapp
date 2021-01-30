package com.mtjin.presentation.di.data

import android.content.Context
import androidx.room.Room
import com.mtjin.data.db.MovieDao
import com.mtjin.data.db.MovieDatabase
import com.mtjin.data.repository.login.local.LoginLocalDataSource
import com.mtjin.data.repository.login.local.LoginLocalDataSourceImpl
import com.mtjin.data.repository.search.local.MovieLocalDataSource
import com.mtjin.data.repository.search.local.MovieLocalDataSourceImpl
import com.mtjin.data.utils.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class LocalDataModule {

    //localRepo
    @Provides
    @Reusable
    fun provideLoginLocalDataSource(preferenceManager: PreferenceManager): LoginLocalDataSource {
        return LoginLocalDataSourceImpl(preferenceManager)
    }

    @Provides
    @Reusable
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    //room
    @Provides
    @Reusable
    fun provideDatabase(context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java, "Movie.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Reusable
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao()
    }

    // sharedPref
    @Provides
    @Reusable
    fun providePreferenceManager(context: Context): PreferenceManager {
        return PreferenceManager((context))
    }

}