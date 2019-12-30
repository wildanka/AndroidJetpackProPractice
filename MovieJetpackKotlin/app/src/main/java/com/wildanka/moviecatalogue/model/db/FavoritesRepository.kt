package com.wildanka.moviecatalogue.model.db

import android.app.Application
import androidx.lifecycle.LiveData
import com.wildanka.moviecatalogue.model.entity.FavoriteMovie
import com.wildanka.moviecatalogue.model.entity.FavoriteTVShow
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.paging.DataSource


class FavoritesRepository(application: Application) {
    private var mFavoritesDao: FavoritesDao? = null
    private var executorService: ExecutorService? = null

    init {
        executorService = Executors.newSingleThreadExecutor()

        val db = MovieCatalogueDatabase.getInstance(application)
        mFavoritesDao = db?.favoritesDao()
    }

    fun getAllFavoriteMovies() : LiveData<List<FavoriteMovie>>? {
        return mFavoritesDao?.getAllFavoriteMovies()
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

    fun getAllFavoriteTVShow() : LiveData<List<FavoriteTVShow>>? {
        return mFavoritesDao?.getAllFavoriteTVShow()
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

    fun getAllFavoriteTVShowPaging(): DataSource.Factory<Int, FavoriteTVShow>? {
        return mFavoritesDao?.getAllFavoritTVShowPaging()
    }
}