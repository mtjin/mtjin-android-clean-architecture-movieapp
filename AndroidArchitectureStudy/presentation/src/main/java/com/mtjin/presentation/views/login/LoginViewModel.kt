package com.mtjin.presentation.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtjin.domain.usecase.InsertLoginUseCase

class LoginViewModel(private val insertLoginUseCase: InsertLoginUseCase) : ViewModel() {
    val id: MutableLiveData<String> = MutableLiveData("")
    val pw: MutableLiveData<String> = MutableLiveData("")
    private val _isIdEmpty: MutableLiveData<Unit> = MutableLiveData()
    private val _isPwEmpty: MutableLiveData<Unit> = MutableLiveData()
    private val _loginErrorMsg: MutableLiveData<Unit> = MutableLiveData()
    private val _successLogin: MutableLiveData<Unit> = MutableLiveData()

    val isIdEmpty: LiveData<Unit> get() = _isIdEmpty
    val isPwEmpty: LiveData<Unit> get() = _isPwEmpty
    val loginErrorMsg: LiveData<Unit> get() = _loginErrorMsg
    val successLogin: LiveData<Unit> get() = _successLogin

    fun onLoginClick() {
        val id = id.value.toString().trim()
        val pw = pw.value.toString().trim()
        if (id.isEmpty()) {
            _isIdEmpty.value = Unit
        } else if (pw.isEmpty()) {
            _isPwEmpty.value = Unit
        } else if (id != USER_ID || pw != USER_PW) {
            _loginErrorMsg.value = Unit
        } else {
            insertLoginUseCase.execute(true)
            _successLogin.value = Unit
        }
    }

    companion object { //이 아이디와 비번으로만 로그인이 가능 (서버X)
        private const val USER_ID = "id"
        private const val USER_PW = "pass"
    }
}