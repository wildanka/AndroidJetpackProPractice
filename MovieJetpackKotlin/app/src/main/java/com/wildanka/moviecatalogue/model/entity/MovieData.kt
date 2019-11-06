package com.wildanka.moviecatalogue.model.entity

import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class MovieData(
    @SerializedName("id") val idMovie: String?,
    @SerializedName("vote_count") val voteCount: BigInteger?,
    @SerializedName("title") val title: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("popularity") val popularity: String?,
    @SerializedName("adult") val adult: Boolean?
)

data class MovieFeeds(
    @SerializedName("results")
    val movieList: MutableList<MovieData>?
)