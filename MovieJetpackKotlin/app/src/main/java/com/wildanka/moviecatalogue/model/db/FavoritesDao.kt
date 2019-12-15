package com.wildanka.moviecatalogue.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wildanka.moviecatalogue.model.entity.MovieData

@Dao
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