package com.wildanka.moviecatalogue.di

import android.content.Context
import com.wildanka.moviecatalogue.data.FavoritesRepository
import com.wildanka.moviecatalogue.data.datasource.local.LocalDataSource
import com.wildanka.moviecatalogue.data.datasource.local.MovieCatalogueDatabase
import com.wildanka.moviecatalogue.util.AppExecutors

object Injection {
    fun provideRepository(context: Context): FavoritesRepository {

        val database = MovieCatalogueDatabase.getInstance(context)

        val localDataSource = LocalDataSource.getInstance(database.favoritesDao())
        val appExecutors = AppExecutors()

        return FavoritesRepository.getInstance(localDataSource, appExecutors)
    }

}