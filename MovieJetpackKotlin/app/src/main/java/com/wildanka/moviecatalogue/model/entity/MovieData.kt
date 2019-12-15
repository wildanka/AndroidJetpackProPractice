package com.wildanka.moviecatalogue.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.math.BigInteger

@Entity(tableName = "movies")
data class MovieData(
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    @SerializedName("id") val idMovie: String,
    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count") val voteCount: Long?,
    @ColumnInfo(name = "title")
    @SerializedName("title") val title: String?,
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date") val releaseDate: String?,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average") val voteAverage: Double?,
    @ColumnInfo(name = "overview")
    @SerializedName("overview") val overview: String?,
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path") val posterPath: String?,
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language") val originalLanguage: String?,
    @ColumnInfo(name = "popularity")
    @SerializedName("popularity") val popularity: String?,
    @ColumnInfo(name = "adult")
    @SerializedName("adult") val adult: Boolean?
)

data class MovieFeeds(
    @SerializedName("results")
    val movieList: MutableList<MovieData>?
)

data class MovieDetail(
    @SerializedName("id") val idMovie: String?,
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genres") val genres: MutableList<Genre?>,
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