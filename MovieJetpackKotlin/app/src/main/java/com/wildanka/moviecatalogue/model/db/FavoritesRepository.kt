package com.wildanka.moviecatalogue.model.db

import android.app.Application
import androidx.lifecycle.LiveData
import com.wildanka.moviecatalogue.model.entity.MovieData
import com.wildanka.moviecatalogue.model.entity.MovieDetail
import com.wildanka.moviecatalogue.model.entity.MovieFavorites
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoritesRepository(application: Application) {
    private var mFavoritesDao: FavoritesDao? = null
    private var executorService: ExecutorService? = null

    init {
        executorService = Executors.newSingleThreadExecutor()

        val db = MovieCatalogueDatabase.getInstance(application)
        mFavoritesDao = db?.favoritesDao()
    }

    fun getAllFavoriteMovies() : LiveData<List<MovieFavorites>>? {
        return mFavoritesDao?.getAllFavoriteMovies()
    }

    fun addToFavoriteMovies(favoriteMovieData: MovieFavorites){
        executorService?.execute(Runnable {
            mFavoritesDao?.insertFavoriteMovie(favoriteMovieData)
        })
    }

    fun removeFromFavoriteMovies(favoriteMovieData: MovieFavorites){
        executorService?.execute(Runnable {
            mFavoritesDao?.deleteFavoriteMovie(favoriteMovieData)
        })
    }

    fun getFavoriteMoviesDetails(idMovie: String?) : LiveData<MovieFavorites>? {
        return mFavoritesDao?.getFavoriteMovieDetails(idMovie)
    }
}