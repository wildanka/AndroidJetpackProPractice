package com.wildanka.moviecatalogue.di

import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.data.datasource.remote.RemoteDataSource

object MovieInjection {
    fun provideRepository(): MoviesRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return MoviesRepository.getInstance(remoteDataSource)
    }

}