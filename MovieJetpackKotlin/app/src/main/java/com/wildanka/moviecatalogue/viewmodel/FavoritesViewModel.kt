package com.wildanka.moviecatalogue.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.model.db.FavoritesRepository
import com.wildanka.moviecatalogue.model.entity.MovieData

class FavoritesViewModel(application: Application) : ViewModel(){
    private var favoritesRepository: FavoritesRepository? = null

    init {
        favoritesRepository = FavoritesRepository(application)
    }

    fun getAllFavoritesMovies() : LiveData<List<MovieData>>? {
        return favoritesRepository?.getAllFavoriteMovies()
    }
}