package com.mtjin.presentation.di.data

import com.mtjin.domain.repository.LoginRepository
import com.mtjin.domain.repository.MovieRepository
import com.mtjin.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetLocalMoviesUseCase(movieRepository: MovieRepository): GetLocalMoviesUseCase {
        return GetLocalMoviesUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideGetLoginUseCase(loginRepository: LoginRepository): GetLoginUseCase {
        return GetLoginUseCase(loginRepository)
    }

    @Provides
    @Singleton
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideGetPagingMoviesUseCase(movieRepository: MovieRepository): GetPagingMoviesUseCase {
        return GetPagingMoviesUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideInsertLoginUseCase(loginRepository: LoginRepository): InsertLoginUseCase {
        return InsertLoginUseCase(loginRepository)
    }

}