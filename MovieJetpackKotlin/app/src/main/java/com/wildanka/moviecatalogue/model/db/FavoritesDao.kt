package com.wildanka.moviecatalogue.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wildanka.moviecatalogue.model.entity.FavoriteMovie
import com.wildanka.moviecatalogue.model.entity.FavoriteTVShow

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

    @Query("SELECT * FROM favorite_movies")
    fun getAllFavoriteTVShow(): LiveData<List<FavoriteMovie>>

    @Query("SELECT * FROM favorite_tv_show WHERE idTVShow LIKE :idTVShow LIMIT 1")
    fun getFavoriteTVShowDetails(idTVShow: String?): LiveData<FavoriteTVShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteTVShow(movieDataFavorite: FavoriteTVShow)

    @Delete
    fun deleteFavoriteTVShow(movieDataFavorite: FavoriteTVShow)

}