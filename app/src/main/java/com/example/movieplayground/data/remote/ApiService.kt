package com.example.movieplayground.data.remote

import com.example.movieplayground.util.Constants
import com.example.movieplayground.domain.models.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getMovie(): Response<Movie>

}