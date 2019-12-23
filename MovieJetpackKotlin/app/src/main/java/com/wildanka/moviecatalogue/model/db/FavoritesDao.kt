package com.wildanka.moviecatalogue.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wildanka.moviecatalogue.model.entity.FavoriteMovie

@Dao
interface FavoritesDao{
    @Query("SELECT * FROM favorite_movies")
    fun getAllFavoriteMovies(): LiveData<List<FavoriteMovie>>

    @Query("SELECT * FROM favorite_movies WHERE idMovie LIKE :idMovie LIMIT 1")
    fun getFavoriteMovieDetails(idMovie: String?): LiveData<FavoriteMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(movieDataFavorite: FavoriteMovie)

    @Delete
    fun deleteFavoriteMovie(movieDataFavorite: FavoriteMovie)

}