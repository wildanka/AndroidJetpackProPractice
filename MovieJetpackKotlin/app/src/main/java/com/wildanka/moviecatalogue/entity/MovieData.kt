package com.wildanka.moviecatalogue.entity

import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("id") val idMovie: String?,
    @SerializedName("vote_count") val voteCount: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("vote_average") val voteAverage: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("popularity") val popularity: String?,
    @SerializedName("adult") val adult: Boolean?
)

data class MovieFeed(
    @SerializedName("results")
    val movieList: List<MovieData>?
)