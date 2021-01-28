package com.mtjin.androidarchitecturestudy.presention.module

import com.mtjin.androidarchitecturestudy.data.repository.search.dataSource.MovieCacheDataSource
import com.mtjin.androidarchitecturestudy.data.repository.search.dataSourceImpl.MovieCacheDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val cacheDataModule: Module = module {
    single<MovieCacheDataSource> { MovieCacheDataSourceImpl() }
}