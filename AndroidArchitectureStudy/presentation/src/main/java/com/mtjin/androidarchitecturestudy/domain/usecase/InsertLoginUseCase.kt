package com.mtjin.androidarchitecturestudy.domain.usecase

import com.mtjin.androidarchitecturestudy.domain.repository.LoginRepository

class InsertLoginUseCase(private val repository: LoginRepository) {
    fun execute(success: Boolean) { // 다음 앱 실행부터는 자동로그인되게끔 플래그 저장
        repository.autoLogin = success
    }
}