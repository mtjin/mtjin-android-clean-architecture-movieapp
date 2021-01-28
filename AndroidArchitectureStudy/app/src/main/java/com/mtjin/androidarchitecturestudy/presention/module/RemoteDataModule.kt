package com.mtjin.androidarchitecturestudy.presention.module

import com.mtjin.androidarchitecturestudy.data.repository.search.dataSource.MovieRemoteDataSource
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSourceImpl.MovieRemoteDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val remoteDataModule: Module = module {
    single<MovieRemoteDataSource> { MovieRemoteDataSourceImpl(get()) }
}