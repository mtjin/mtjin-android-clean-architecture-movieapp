package com.mtjin.androidarchitecturestudy.presention.module

import androidx.room.Room
import com.mtjin.androidarchitecturestudy.data.repository.login.dataSource.LoginLocalDataSource
import com.mtjin.androidarchitecturestudy.data.repository.login.dataSourceImpl.LoginLocalDataSourceImpl
import com.mtjin.androidarchitecturestudy.data.db.MovieDao
import com.mtjin.androidarchitecturestudy.data.db.MovieDatabase
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSource.MovieLocalDataSource
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSourceImpl.MovieLocalDataSourceImpl
import com.mtjin.androidarchitecturestudy.presention.utils.PreferenceManager
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