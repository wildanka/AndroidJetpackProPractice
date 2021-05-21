package com.wildanka.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.di.MovieInjection
import com.wildanka.moviecatalogue.presentation.ui.movies.MainMoviesViewModel
import com.wildanka.moviecatalogue.presentation.ui.movies.MoviesDetailViewModel
import com.wildanka.moviecatalogue.presentation.ui.search.SearchViewModel

class ViewModelFactory private constructor(private val mMoviesRepository: MoviesRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this){
                ViewModelFactory(MovieInjection.provideRepository()).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesDetailViewModel::class.java) -> {
                MoviesDetailViewModel(mMoviesRepository) as T
            }
            modelClass.isAssignableFrom(MainMoviesViewModel::class.java) -> {
                MainMoviesViewModel(mMoviesRepository) as T
            }
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> {
                SearchViewModel(mMoviesRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)

        }
    }
}