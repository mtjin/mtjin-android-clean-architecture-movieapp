package com.mtjin.presentation.views.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.mtjin.presentation.base.BaseActivity
import com.mtjin.presentation.views.search.MovieSearchActivity
import com.mtjin.presentation.R
import com.mtjin.presentation.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initViewModelCallback()
    }

    private fun initViewModelCallback() {
        with(viewModel) {
            isIdEmpty.observe(this@LoginActivity, Observer {
                showIdEmptyError()
            })
            isPwEmpty.observe(this@LoginActivity, Observer {
                showPwEmptyError()
            })
            loginErrorMsg.observe(this@LoginActivity, Observer {
                showToast(getString(R.string.id_pw_not_correct_error_msg))
            })
            successLogin.observe(this@LoginActivity, Observer {
                goMovieSearch()
            })
        }
    }

    private fun showIdEmptyError() {
        binding.etId.error = getString(R.string.id_empty_error_msg)
    }

    private fun showPwEmptyError() {
        binding.etPw.error = getString(R.string.pw_empty_error_msg)
    }

    private fun goMovieSearch() {
        showToast(getString(R.string.login_success_msg))
        startActivity(Intent(this, MovieSearchActivity::class.java))
        finish()
    }


}
