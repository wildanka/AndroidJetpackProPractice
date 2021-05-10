package com.wildanka.moviecatalogue.domain.entity

import com.google.gson.annotations.SerializedName
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData

data class MovieFeeds(
    @SerializedName("results")
    val movieList: MutableList<MovieData>?
)

