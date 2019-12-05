package com.wildanka.moviecatalogue.model.db

import android.app.Application
import androidx.lifecycle.LiveData
import com.wildanka.moviecatalogue.model.entity.MovieData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoritesRepository(application: Application) {
    private var mFavoritesDao: FavoritesDao? = null
    private var executorService: ExecutorService? = null

    init {
        executorService = Executors.newSingleThreadExecutor()

        val db = MovieCatalogueDatabase.getDatabase(application)
        mFavoritesDao = db?.favoritesDao()
    }

    fun getAllFavoriteMovies() : LiveData<List<MovieData>>? {
        return mFavoritesDao?.getAllFavoriteMovies()
    }

    fun addToFavoriteMovies(favoriteMovieData: MovieData){
        executorService?.execute(Runnable {
            mFavoritesDao?.insertFavoriteMovie(favoriteMovieData)
        })
    }

    fun removeFromFavoriteMovies(favoriteMovieData: MovieData){
        executorService?.execute(Runnable {
            mFavoritesDao?.deleteFavoriteMovie(favoriteMovieData)
        })
    }
}