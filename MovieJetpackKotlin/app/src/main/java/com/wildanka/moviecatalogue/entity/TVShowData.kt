package com.wildanka.moviecatalogue.entity

import com.google.gson.annotations.SerializedName

data class TVShowData(
    @SerializedName("id") val idTVShow: String?,
    @SerializedName("vote_count") val voteCount: String?,
    @SerializedName("original_name") val originalName: String?,
    @SerializedName("name") val title: String?,
    @SerializedName("first_air_date") val airDate: String?,
    @SerializedName("vote_average") val voteAverage: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("popularity") val popularity: String?
)


data class TVShowFeed(
    @SerializedName("results")
    val movieList: List<TVShowData>?
)