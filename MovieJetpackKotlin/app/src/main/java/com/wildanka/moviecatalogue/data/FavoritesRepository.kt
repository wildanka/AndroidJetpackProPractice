package com.wildanka.moviecatalogue.data

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import androidx.paging.DataSource
import com.wildanka.moviecatalogue.data.datasource.local.FavoritesDao
import com.wildanka.moviecatalogue.data.datasource.local.MovieCatalogueDatabase
import com.wildanka.moviecatalogue.domain.entity.FavoriteMovie
import com.wildanka.moviecatalogue.domain.entity.FavoriteTVShow


class FavoritesRepository(application: Application) {
    private var mFavoritesDao: FavoritesDao? = null
    private var executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = MovieCatalogueDatabase.getInstance(application)
        mFavoritesDao = db.favoritesDao()
    }

    fun getAllFavoriteMoviePaging(): DataSource.Factory<Int, FavoriteMovie>? {
        return mFavoritesDao?.getAllFavoritMoviePaging()
    }

    fun addToFavoriteMovies(favoriteMovieData: FavoriteMovie){
        executorService.execute { mFavoritesDao?.insertFavoriteMovie(favoriteMovieData) }
    }

    fun removeFromFavoriteMovies(favoriteMovieData: FavoriteMovie){
        executorService.execute {
            mFavoritesDao?.deleteFavoriteMovie(favoriteMovieData)
        }
    }

    fun getFavoriteMoviesDetails(idMovie: String?) : LiveData<FavoriteMovie>? {
        return mFavoritesDao?.getFavoriteMovieDetails(idMovie)
    }

    //TODO : What to do with this DataSource.Factory
    fun getAllFavoriteTVShowPaging(): DataSource.Factory<Int, FavoriteTVShow>? {
        return mFavoritesDao?.getAllFavoritTVShowPaging()
    }

    fun addToFavoriteTVShow(favoriteTVShowData: FavoriteTVShow){
        executorService.execute { mFavoritesDao?.insertFavoriteTVShow(favoriteTVShowData) }
    }

    fun removeFromFavoriteTVShow(favoriteTVShowData: FavoriteTVShow){
        executorService.execute {
            mFavoritesDao?.deleteFavoriteTVShow(favoriteTVShowData)
        }
    }

    fun getFavoriteTVShowDetails(idTVShow: String?) : LiveData<FavoriteTVShow>? {
        return mFavoritesDao?.getFavoriteTVShowDetails(idTVShow)
    }

}