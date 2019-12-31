package com.wildanka.moviecatalogue.favorite.repo

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import androidx.paging.DataSource
import com.wildanka.moviecatalogue.favorite.model.db.FavoritesDao
import com.wildanka.moviecatalogue.favorite.model.db.MovieCatalogueDatabase
import com.wildanka.moviecatalogue.favorite.model.entity.FavoriteMovie
import com.wildanka.moviecatalogue.favorite.model.entity.FavoriteTVShow


class FavoritesRepository(application: Application) {
    private var mFavoritesDao: FavoritesDao? = null
    private var executorService: ExecutorService? = null

    init {
        executorService = Executors.newSingleThreadExecutor()

        val db = MovieCatalogueDatabase.getInstance(application)
        mFavoritesDao = db?.favoritesDao()
    }

    fun getAllFavoriteMoviePaging(): DataSource.Factory<Int, FavoriteMovie>? {
        return mFavoritesDao?.getAllFavoritMoviePaging()
    }

    fun addToFavoriteMovies(favoriteMovieData: FavoriteMovie){
        executorService?.execute(Runnable {
            mFavoritesDao?.insertFavoriteMovie(favoriteMovieData)
        })
    }

    fun removeFromFavoriteMovies(favoriteMovieData: FavoriteMovie){
        executorService?.execute(Runnable {
            mFavoritesDao?.deleteFavoriteMovie(favoriteMovieData)
        })
    }

    fun getFavoriteMoviesDetails(idMovie: String?) : LiveData<FavoriteMovie>? {
        return mFavoritesDao?.getFavoriteMovieDetails(idMovie)
    }

    fun getAllFavoriteTVShowPaging(): DataSource.Factory<Int, FavoriteTVShow>? {
        return mFavoritesDao?.getAllFavoritTVShowPaging()
    }

    fun addToFavoriteTVShow(favoriteTVShowData: FavoriteTVShow){
        executorService?.execute(Runnable {
            mFavoritesDao?.insertFavoriteTVShow(favoriteTVShowData)
        })
    }

    fun removeFromFavoriteTVShow(favoriteTVShowData: FavoriteTVShow){
        executorService?.execute(Runnable {
            mFavoritesDao?.deleteFavoriteTVShow(favoriteTVShowData)
        })
    }

    fun getFavoriteTVShowDetails(idTVShow: String?) : LiveData<FavoriteTVShow>? {
        return mFavoritesDao?.getFavoriteTVShowDetails(idTVShow)
    }

}