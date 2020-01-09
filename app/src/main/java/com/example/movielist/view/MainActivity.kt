package com.example.movielist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.R
import com.example.movielist.adapter.MovieAdapter
import com.example.movielist.model.Movie
import com.example.movielist.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val movieArrayList = arrayListOf<Movie>()
    private val movieAdapter = MovieAdapter(movieArrayList) { movie -> onMovieClicked(movie) }
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.movieList.observe(this, Observer {
            movieArrayList.clear()
            movieArrayList.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun initViews() {
        rvMovies.layoutManager =
            GridLayoutManager(this@MainActivity, 2, RecyclerView.VERTICAL, false)
        rvMovies.adapter = movieAdapter

        btnSubmit.setOnClickListener {
            viewModel.getMovies(etYearRelease.text.toString())
        }
    }

    private fun startMovieSummaryActivity(movie: Movie) {
        val intent = Intent(this, MovieSummaryActivity::class.java)
        intent.putExtra("Movie", movie)
        startActivity(intent)
    }

    private fun onMovieClicked(movie: Movie) {
        startMovieSummaryActivity(movie)
    }
}
