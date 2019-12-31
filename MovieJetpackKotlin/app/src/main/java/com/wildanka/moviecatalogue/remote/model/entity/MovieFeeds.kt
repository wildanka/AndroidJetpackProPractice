package com.wildanka.moviecatalogue.remote.model.entity

import com.google.gson.annotations.SerializedName

data class MovieFeeds(
    @SerializedName("results")
    val movieList: MutableList<MovieData>?
)

