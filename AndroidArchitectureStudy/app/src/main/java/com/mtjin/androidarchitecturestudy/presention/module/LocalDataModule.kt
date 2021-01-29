package com.mtjin.androidarchitecturestudy.presention.module

import androidx.room.Room
import com.mtjin.androidarchitecturestudy.data.repository.login.local.LoginLocalDataSource
import com.mtjin.androidarchitecturestudy.data.repository.login.local.LoginLocalDataSourceImpl
import com.mtjin.androidarchitecturestudy.data.db.MovieDao
import com.mtjin.androidarchitecturestudy.data.db.MovieDatabase
import com.mtjin.androidarchitecturestudy.data.repository.search.local.MovieLocalDataSource
import com.mtjin.androidarchitecturestudy.data.repository.search.local.MovieLocalDataSourceImpl
import com.mtjin.androidarchitecturestudy.utils.PreferenceManager
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