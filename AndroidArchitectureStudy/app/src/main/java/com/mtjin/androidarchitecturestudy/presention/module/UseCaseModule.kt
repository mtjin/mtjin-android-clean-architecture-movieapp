package com.mtjin.androidarchitecturestudy.presention.module

import com.mtjin.androidarchitecturestudy.domain.usecase.*
import org.koin.core.module.Module
import org.koin.dsl.module

val useCaseModule: Module = module {
    single<GetLoginUseCase> { GetLoginUseCase(get()) }
    single<GetMoviesUseCase> { GetMoviesUseCase(get()) }
    single<InsertLoginUseCase> { InsertLoginUseCase(get()) }
    single<GetPagingMoviesUseCase> { GetPagingMoviesUseCase(get()) }
    single<GetLocalMoviesUseCase> { GetLocalMoviesUseCase(get()) }

}