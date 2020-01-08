package com.example.movielist.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(

    @SerializedName("title") var title: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("rating") var rating: String,
    @SerializedName("background") var backgroundImageUrl: String,
    @SerializedName("poster") var posterImageUrl: String

) : Parcelable {
    fun getPosterUrl() = "https://image.tmdb.org/t/p/original$posterImageUrl"
    fun getBackdropUrl() = "https://image.tmdb.org/t/p/original$backgroundImageUrl"
}