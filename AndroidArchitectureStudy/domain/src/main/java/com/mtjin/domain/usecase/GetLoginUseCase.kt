package com.mtjin.domain.usecase

import com.mtjin.domain.repository.LoginRepository

class GetLoginUseCase(private val repository: LoginRepository) {
    fun execute(): Boolean = repository.autoLogin //자동로그인 : 이전 로그인 기록있으면 자동로그인이 된다
}