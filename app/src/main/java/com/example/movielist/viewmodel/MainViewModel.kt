package com.example.movielist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.movielist.data.MovieRepository
import com.example.movielist.model.Movie
import com.example.movielist.model.MovieList

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val error = MutableLiveData<String>()
    val movieList = MutableLiveData<List<Movie>>()
    val movieRepo = MovieRepository()

    fun getMovies(year: String) {
        movieRepo.getMovies(year).enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (response.isSuccessful) movieList.value = response.body()?.movies
                else error.value = "An error occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}