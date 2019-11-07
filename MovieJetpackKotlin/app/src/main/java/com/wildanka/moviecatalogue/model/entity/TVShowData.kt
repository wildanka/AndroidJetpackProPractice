package com.wildanka.moviecatalogue.model.entity

import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class TVShowData(
    @SerializedName("id") val idTVShow: String?,
    @SerializedName("vote_count") val voteCount: BigInteger?,
    @SerializedName("original_name") val originalName: String?,
    @SerializedName("name") val title: String?,
    @SerializedName("first_air_date") val airDate: String?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("popularity") val popularity: String?
)

data class TVShowFeeds(
    @SerializedName("results")
    val tvShowList: MutableList<TVShowData>?
)

data class TVShowDetail(
    @SerializedName("id") val idMovie: String?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genres") val genres: MutableList<Genre?>,
    @SerializedName("homepage") val homePageUrl: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("first_air_date") val firstAirDate: String?,
    @SerializedName("last_air_date") val lastAirDate: String?,
    @SerializedName("revenue") val revenue: String?,
    @SerializedName("runtime") val duration: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("tagline") val tagline: String?,
    @SerializedName("name") val title: String?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("vote_count") val voteCount: String?
)
