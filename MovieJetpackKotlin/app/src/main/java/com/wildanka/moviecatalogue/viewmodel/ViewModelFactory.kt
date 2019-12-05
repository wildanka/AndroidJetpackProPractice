package com.wildanka.moviecatalogue.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class ViewModelFactory(application: Application) : ViewModelProvider.NewInstanceFactory() {
    private var mApplication: Application? = null

    init {
        this.mApplication = application
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = ViewModelFactory(application)
                    }
                }
            }
            return INSTANCE
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesDetailViewModel::class.java)) {
            return MoviesDetailViewModel() as T
        } else if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            return FavoritesViewModel(mApplication!!) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName())
//        return super.create(modelClass)
    }
}