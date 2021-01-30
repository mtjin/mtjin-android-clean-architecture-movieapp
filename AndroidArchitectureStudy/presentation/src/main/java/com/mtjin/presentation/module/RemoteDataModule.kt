package com.mtjin.presentation.module

import com.mtjin.data.repository.search.remote.MovieRemoteDataSource
import com.mtjin.data.repository.search.remote.MovieRemoteDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val remoteDataModule: Module = module {
    single<MovieRemoteDataSource> { MovieRemoteDataSourceImpl(get()) }
}