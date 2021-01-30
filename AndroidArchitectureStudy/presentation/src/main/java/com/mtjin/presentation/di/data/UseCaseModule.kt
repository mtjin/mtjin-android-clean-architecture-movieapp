package com.mtjin.presentation.di.data

import com.mtjin.domain.repository.LoginRepository
import com.mtjin.domain.repository.MovieRepository
import com.mtjin.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetLocalMoviesUseCase(movieRepository: MovieRepository): GetLocalMoviesUseCase {
        return GetLocalMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetLoginUseCase(loginRepository: LoginRepository): GetLoginUseCase {
        return GetLoginUseCase(loginRepository)
    }

    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetPagingMoviesUseCase(movieRepository: MovieRepository): GetPagingMoviesUseCase {
        return GetPagingMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideInsertLoginUseCase(loginRepository: LoginRepository): InsertLoginUseCase {
        return InsertLoginUseCase(loginRepository)
    }

}