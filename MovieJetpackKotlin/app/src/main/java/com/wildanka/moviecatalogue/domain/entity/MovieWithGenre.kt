package com.wildanka.moviecatalogue.domain.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData

data class MovieWithGenre(
    @Embedded val movie: MovieData,
    @Relation(
        parentColumn = "movieId",
        entityColumn= "genreId",
        associateBy = Junction(MovieGenreCrossRef::class)
    )
    val genre: List<Genre>
)