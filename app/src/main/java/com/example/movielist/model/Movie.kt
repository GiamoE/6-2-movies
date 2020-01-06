package com.example.movielist.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("backdrop_path") var backdropImageUrl: String,
    @SerializedName("poster_path") var posterImageUrl: String,
    @SerializedName("title") var title: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var rating: String,
    @SerializedName("overview") var overview: String
) : Parcelable {

    fun getBackdropUrl() = "https://image.tmdb.org/t/p/original$backdropImageUrl"
    fun getPosterUrl() = "https://image.tmdb.org/t/p/original$posterImageUrl"
}