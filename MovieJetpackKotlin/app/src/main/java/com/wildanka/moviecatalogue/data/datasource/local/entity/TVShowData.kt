package com.wildanka.moviecatalogue.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.wildanka.moviecatalogue.domain.entity.Genre

@Entity(tableName = "tv_show")
data class TVShowData(
    @PrimaryKey
    @ColumnInfo(name = "tv_show_id") @SerializedName("id") val idTVShow: String,
    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count") val voteCount: Long?,
    @ColumnInfo(name = "original_name")
    @SerializedName("original_name") val originalName: String?,
    @ColumnInfo(name = "name")
    @SerializedName("name") val title: String?,
    @ColumnInfo(name = "first_air_date")
    @SerializedName("first_air_date") val airDate: String?,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average") val voteAverage: Double?,
    @ColumnInfo(name = "overview")
    @SerializedName("overview") val overview: String?,
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path") val posterPath: String?,
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language") val originalLanguage: String?,
    @ColumnInfo(name = "popularity")
    @SerializedName("popularity") val popularity: String?
)

data class TVShowFeeds(
    @SerializedName("results")
    val tvShowList: MutableList<TVShowData>?
)

data class TVShowDetail(
    @SerializedName("id") val idMovie: String,
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
