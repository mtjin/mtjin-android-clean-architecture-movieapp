package com.mtjin.presentation.module

import androidx.room.Room
import com.mtjin.data.db.MovieDao
import com.mtjin.data.db.MovieDatabase
import com.mtjin.data.repository.login.local.LoginLocalDataSource
import com.mtjin.data.repository.login.local.LoginLocalDataSourceImpl
import com.mtjin.data.repository.search.local.MovieLocalDataSource
import com.mtjin.data.repository.search.local.MovieLocalDataSourceImpl
import com.mtjin.data.utils.PreferenceManager
import org.koin.core.module.Module
import org.koin.dsl.module

val localDataModule: Module = module {
    single<MovieLocalDataSource> { MovieLocalDataSourceImpl(get()) }
    single<LoginLocalDataSource> { LoginLocalDataSourceImpl(get()) }
    single<PreferenceManager> { PreferenceManager(get()) }
    single<MovieDao> { get<MovieDatabase>().movieDao() }
    single<MovieDatabase> {
        Room.databaseBuilder(
            get(),
            MovieDatabase::class.java, "Movie.db"
        )
            .build()
    }
}