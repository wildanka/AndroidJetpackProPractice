package com.wildanka.moviecatalogue.data.datasource.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class MovieWithCast(
    @Embedded
    var mMovieCast: MovieData,

    @Relation(parentColumn = "movie_id", entityColumn = "movie_id")
    var mModules: List<MovieCast>
)