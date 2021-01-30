package com.mtjin.presentation.module

import com.mtjin.domain.repository.LoginRepository
import com.mtjin.data.repository.login.LoginRepositoryImpl
import com.mtjin.domain.repository.MovieRepository
import com.mtjin.data.repository.search.MovieRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
}