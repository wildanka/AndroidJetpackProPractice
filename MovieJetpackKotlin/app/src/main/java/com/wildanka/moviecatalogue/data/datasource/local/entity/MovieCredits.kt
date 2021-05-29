package com.wildanka.moviecatalogue.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.wildanka.moviecatalogue.domain.entity.MovieCast

@Entity
data class MovieCredits(
    @PrimaryKey
    @ColumnInfo(name = "idMOvie")
    @SerializedName("id") val idMovie: String?,
    @ColumnInfo(name = "description")
    @SerializedName("cast") val cast: MutableList<MovieCast>
)
