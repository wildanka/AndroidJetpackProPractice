package com.wildanka.moviecatalogue.domain.entity

import androidx.room.Entity

@Entity(primaryKeys = ["movieId", "genreId"])
data class MovieGenreCrossRef(
    val movieId: String,
    val genreId: String
)