package com.wildanka.moviecatalogue.presentation.ui.favorites

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wildanka.moviecatalogue.data.FavoritesRepository
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.di.Injection
import com.wildanka.moviecatalogue.di.MovieInjection

class FavoritesViewModelFactory private constructor(private val mFavoritesRepository: FavoritesRepository, private val mMoviesRepository: MoviesRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: FavoritesViewModelFactory? = null

        fun getInstance(context: Context): FavoritesViewModelFactory =
            instance ?: synchronized(this) {
                FavoritesViewModelFactory(Injection.provideRepository(context), MovieInjection.provideRepository()).apply {
                    instance = this
                }
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(FavoritesViewModel::class.java) -> {
                FavoritesViewModel(mFavoritesRepository, mMoviesRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}