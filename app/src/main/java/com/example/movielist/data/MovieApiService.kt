package com.example.movielist.data

import com.example.movielist.model.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApiService {
    @GET("discover/movie?api_key=c24f28a36bef9d0cbba92cd2cd01b244")
    fun getMovies(@Query("year") year: String): Call<MovieList>
}