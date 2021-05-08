package com.wildanka.moviecatalogue.domain.entity

import com.google.gson.annotations.SerializedName

data class MovieFeeds(
    @SerializedName("results")
    val movieList: MutableList<MovieData>?
)

