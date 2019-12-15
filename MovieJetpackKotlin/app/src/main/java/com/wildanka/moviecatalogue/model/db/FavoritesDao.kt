package com.wildanka.moviecatalogue.model.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wildanka.moviecatalogue.model.entity.MovieData

interface FavoritesDao{
    @Query("SELECT * FROM movies")
    fun getAllFavoriteMovies(): LiveData<List<MovieData>>

    @Query("SELECT * FROM movies WHERE movie_id LIKE :idMovie LIMIT 1")
    fun getFavoriteMovieDetails(idMovie: String?): LiveData<MovieData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(movieDataFavorite: MovieData)

    @Delete
    fun deleteFavoriteMovie(movieDataFavorite: MovieData)

}