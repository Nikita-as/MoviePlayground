package com.example.movieplayground.repository

import com.example.movieplayground.api.ApiService
import javax.inject.Inject

class MovieRepository
@Inject
constructor(private val apiService: ApiService) {

    suspend fun getMovie() = apiService.getMovie()
}