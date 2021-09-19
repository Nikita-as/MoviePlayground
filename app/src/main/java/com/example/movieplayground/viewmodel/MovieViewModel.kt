package com.example.movieplayground.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieplayground.models.MovieItem
import com.example.movieplayground.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel
@Inject
constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private val _response = MutableLiveData<List<MovieItem>>()
    val responseMovie: LiveData<List<MovieItem>>
        get() = _response

    init {
        getAllMovies()
    }

    private fun getAllMovies() = viewModelScope.launch {

        movieRepository.getMovie().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getAllMovie Error: ${response.code()}")
            }

        }
    }
}