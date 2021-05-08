package com.wildanka.moviecatalogue.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favorite_tv_show")
data class FavoriteTVShow(
    @PrimaryKey
    @SerializedName("id") val idTVShow: String,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genres") val genres: String?,
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
