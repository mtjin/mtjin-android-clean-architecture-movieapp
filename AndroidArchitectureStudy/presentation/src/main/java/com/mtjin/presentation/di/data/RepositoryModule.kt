package com.mtjin.presentation.di.data


import com.mtjin.data.repository.login.LoginRepositoryImpl
import com.mtjin.data.repository.login.local.LoginLocalDataSource
import com.mtjin.data.repository.search.MovieRepositoryImpl
import com.mtjin.data.repository.search.local.MovieLocalDataSource
import com.mtjin.data.repository.search.remote.MovieRemoteDataSource
import com.mtjin.domain.repository.LoginRepository
import com.mtjin.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {
    @Provides
    @Reusable
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource)
    }

    @Provides
    @Reusable
    fun provideLoginRepository(loginLocalDataSource: LoginLocalDataSource): LoginRepository {
        return LoginRepositoryImpl(loginLocalDataSource)
    }

}