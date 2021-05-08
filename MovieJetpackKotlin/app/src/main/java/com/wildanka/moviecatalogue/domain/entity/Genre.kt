package com.wildanka.moviecatalogue.domain.entity

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id") val idGenres: String?,
    @SerializedName("name") val genreName: String?
)