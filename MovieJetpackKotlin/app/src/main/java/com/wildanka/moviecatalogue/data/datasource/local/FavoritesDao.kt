package com.wildanka.moviecatalogue.data.datasource.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow

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

    //tvShow
    @Query("SELECT * FROM favorite_tv_show")
    fun getAllFavoriteTVShow(): LiveData<List<FavoriteTVShow>>

    @Query("SELECT * FROM favorite_tv_show WHERE idTVShow LIKE :idTVShow LIMIT 1")
    fun getFavoriteTVShowDetails(idTVShow: String?): LiveData<FavoriteTVShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteTVShow(movieDataFavorite: FavoriteTVShow)

    @Delete
    fun deleteFavoriteTVShow(movieDataFavorite: FavoriteTVShow)

    @Query("SELECT * from favorite_tv_show ORDER BY idTVShow ASC")
    fun getAllFavoriteTVShowPaging() : DataSource.Factory<Int, FavoriteTVShow>

    @Query("SELECT * from favorite_movies ORDER BY idMovie ASC")
    fun getAllFavoriteMoviePaging() : DataSource.Factory<Int, FavoriteMovie>


}