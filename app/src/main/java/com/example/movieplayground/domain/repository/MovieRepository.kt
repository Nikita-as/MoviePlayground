package com.example.movieplayground.domain.repository

import com.example.movieplayground.data.remote.ApiService
import javax.inject.Inject

class MovieRepository
@Inject
constructor(private val apiService: ApiService) {

    suspend fun getMovie() = apiService.getMovie()
}