package com.wildanka.moviecatalogue.domain.entity

import com.google.gson.annotations.SerializedName
import com.wildanka.moviecatalogue.domain.entity.Genre

data class MovieDetail(
    @SerializedName("id") val idMovie: String,
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genres") var genres: List<Genre?>,
    @SerializedName("homepage") val homePageUrl: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("revenue") val revenue: String?,
    @SerializedName("runtime") val duration: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("tagline") val tagline: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("vote_count") val voteCount: String?
)