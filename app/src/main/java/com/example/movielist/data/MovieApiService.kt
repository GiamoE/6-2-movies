package com.example.movielist.data

import com.example.movielist.model.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApiService {
    @GET("discover/movie?api_key=423417505f788639e112c74abf8a15c3")
    fun getMovies(@Query("year") year: String): Call<MovieList>
}