package com.mtjin.presentation.views.search

import android.content.Intent
import com.mtjin.presentation.di.MyApplication


import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mtjin.presentation.R
import com.mtjin.presentation.base.BaseActivity
import com.mtjin.presentation.databinding.ActivityMovieSearchBinding
import javax.inject.Inject


class MovieSearchActivity :
    BaseActivity<ActivityMovieSearchBinding>(R.layout.activity_movie_search) {
    private lateinit var movieAdapter: MovieAdapter
    lateinit var moveSearchComponent: MovieSearchComponent

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MovieSearchViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MovieSearchViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        moveSearchComponent =
            (application as MyApplication).appComponent.movieSearchComponent().create()
        moveSearchComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initViewModelCallback()
        initAdapter()
    }

    private fun initAdapter() {
        movieAdapter = MovieAdapter { movie ->
            Intent(Intent.ACTION_VIEW, Uri.parse(movie.link)).takeIf {
                it.resolveActivity(packageManager) != null
            }?.run(this::startActivity)
        }
        binding.rvMovies.adapter = movieAdapter
    }

    private fun initViewModelCallback() {
        with(viewModel) {
            toastMsg.observe(this@MovieSearchActivity, Observer {
                when (toastMsg.value) {
                    MovieSearchViewModel.MessageSet.LAST_PAGE -> showToast(getString(R.string.last_page_msg))
                    MovieSearchViewModel.MessageSet.EMPTY_QUERY -> showToast(getString(R.string.search_input_query_msg))
                    MovieSearchViewModel.MessageSet.NETWORK_NOT_CONNECTED -> showToast(getString(R.string.network_error_msg))
                    MovieSearchViewModel.MessageSet.SUCCESS -> showToast(getString(R.string.load_movie_success_msg))
                    MovieSearchViewModel.MessageSet.NO_RESULT -> showToast(getString(R.string.no_movie_error_msg))
                    MovieSearchViewModel.MessageSet.ERROR -> showToast(getString(R.string.error_msg))
                    MovieSearchViewModel.MessageSet.LOCAL_SUCCESS -> showToast(getString(R.string.local_db_msg))
                }
            })
        }
    }
}
