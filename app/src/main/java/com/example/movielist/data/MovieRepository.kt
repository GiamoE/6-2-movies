package com.example.movielist.data

class MovieRepository {
    private val movieApi = MovieApi.createApi()

    fun getMovies(year: String) = movieApi.getMovies(year)
}