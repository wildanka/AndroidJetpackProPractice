package com.wildanka.moviecatalogue.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wildanka.moviecatalogue.model.entity.MovieData
import com.wildanka.moviecatalogue.model.entity.MovieDetail
import com.wildanka.moviecatalogue.model.entity.MovieFavorites

@Dao
interface FavoritesDao{
    @Query("SELECT * FROM favorite_movies")
    fun getAllFavoriteMovies(): LiveData<List<MovieFavorites>>

    @Query("SELECT * FROM favorite_movies WHERE idMovie LIKE :idMovie LIMIT 1")
    fun getFavoriteMovieDetails(idMovie: String?): LiveData<MovieFavorites>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(movieDataFavorite: MovieFavorites)

    @Delete
    fun deleteFavoriteMovie(movieDataFavorite: MovieFavorites)

}