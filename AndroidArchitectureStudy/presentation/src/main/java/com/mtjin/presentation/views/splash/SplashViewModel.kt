package com.mtjin.presentation.views.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtjin.domain.usecase.GetLoginUseCase

class SplashViewModel(private val getLoginUserCase: GetLoginUseCase) : ViewModel() {
    private val _goMovieSearch: MutableLiveData<Unit> = MutableLiveData()
    private val _goLogin: MutableLiveData<Unit> = MutableLiveData()

    val goMovieSearch: LiveData<Unit> get() = _goMovieSearch
    val goLogin: LiveData<Unit> get() = _goLogin

    fun doSplash() {
        if (getLoginUserCase.execute()) { //자동로그인 가능 여부
            _goMovieSearch.value = Unit
        } else {
            _goLogin.value = Unit
        }
    }
}