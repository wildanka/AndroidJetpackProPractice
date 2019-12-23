package com.wildanka.moviecatalogue.model.entity

import androidx.room.Entity

@Entity(primaryKeys = ["movieId", "genreId"])
data class MovieGenreCrossRef(
    val movieId: String,
    val genreId: String
)