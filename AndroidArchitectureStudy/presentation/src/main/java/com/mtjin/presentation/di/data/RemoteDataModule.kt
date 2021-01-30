package com.mtjin.presentation.di.data

import com.mtjin.data.api.ApiInterface
import com.mtjin.data.repository.search.remote.MovieRemoteDataSource
import com.mtjin.data.repository.search.remote.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Provides
    @Reusable
    fun provideMovieRemoteDataSource(apiInterface: ApiInterface): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(apiInterface)
    }
}