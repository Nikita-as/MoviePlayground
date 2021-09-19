package com.example.movieplayground.api

import com.example.movieplayground.helper.Constants
import com.example.movieplayground.models.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getMovie(): Response<Movie>

}