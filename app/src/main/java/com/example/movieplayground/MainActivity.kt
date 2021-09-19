package com.example.movieplayground

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieplayground.adapter.MovieAdapter
import com.example.movieplayground.databinding.ActivityMainBinding
import com.example.movieplayground.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = "Movie"

        setUpRv()
    }

    private fun setUpRv() {
        val movieAdapter = MovieAdapter()

        binding.recyclerView.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
        viewModel.responseMovie.observe(this,{ listMovies ->
            movieAdapter.listMovies = listMovies

        })

        binding.rvEpisodes.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
        viewModel.responseMovie.observe(this,{ listMovies ->
            movieAdapter.listMovies = listMovies

        })

        binding.rvRecentlyAdded.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
        viewModel.responseMovie.observe(this,{ listMovies ->
            movieAdapter.listMovies = listMovies

        })
    }
}