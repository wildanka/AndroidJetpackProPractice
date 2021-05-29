package com.wildanka.moviecatalogue.data.datasource.local.entity

import androidx.room.*
import com.google.gson.annotations.SerializedName

/*    (
    tableName = "moviecast",
    primaryKeys = ["credit_id", "movie_id"],
    foreignKeys = [ForeignKey(
        entity = MovieData::class,
        parentColumns = ["movie_id"],
        childColumns = ["movie_id"]
    )],
    indices = [Index(value = ["credit_id"]), Index(value = ["movie_id"])]
)*/
@Entity(tableName = "movie_casts")
data class MovieCast(
    @ColumnInfo(name = "movie_id") var movieId: String,
    @PrimaryKey
    @ColumnInfo(name = "credit_id")
    @SerializedName("credit_id") var creditId: String,
    @SerializedName("cast_id") val castId: String?,
    @ColumnInfo(name = "character")
    @SerializedName("character") val character: String?,
    @ColumnInfo(name = "gender")
    @SerializedName("gender") val gender: Int?,
    @ColumnInfo(name = "id")
    @SerializedName("id") val id: String?,
    @ColumnInfo(name = "name")
    @SerializedName("name") val name: String?,
    @ColumnInfo(name = "order")
    @SerializedName("order") val order: String?,
    @ColumnInfo(name = "profile_path")
    @SerializedName("profile_path") val profilePath: String?
)