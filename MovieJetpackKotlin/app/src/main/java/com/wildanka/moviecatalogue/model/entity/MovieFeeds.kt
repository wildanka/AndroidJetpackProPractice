package com.wildanka.moviecatalogue.model.entity

import com.google.gson.annotations.SerializedName

data class MovieFeeds(
    @SerializedName("results")
    val movieList: MutableList<MovieData>?
)

