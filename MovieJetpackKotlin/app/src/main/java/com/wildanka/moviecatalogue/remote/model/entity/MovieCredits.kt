package com.wildanka.moviecatalogue.remote.model.entity

import com.google.gson.annotations.SerializedName

data class MovieCredits(
    @SerializedName("id") val idMovie: String?,
    @SerializedName("cast") val cast: MutableList<MovieCast>
)

data class MovieCast(
    @SerializedName("cast_id") val castId: String?,
    @SerializedName("character") val character: String?,
    @SerializedName("credit_id") val creditId: String?,
    @SerializedName("gender") val gender: Int?,
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("order") val order: String?,
    @SerializedName("profile_path") val profilePath: String?
)
