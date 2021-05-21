package com.wildanka.moviecatalogue.data

import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData
import com.wildanka.moviecatalogue.data.datasource.remote.RemoteDataSource

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource): MoviesDataSource {


    override fun fetchMovieData(): MutableLiveData<MutableList<MovieData>> {
        val movieList = MutableLiveData<MutableList<MovieData>>()
        remoteDataSource.fetchMovieData(object: RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(movieResponse: MutableList<MovieData>) {
                movieList.value = movieResponse
            }
        })
        return movieList
    }

    override fun fetchTVShowData(): MutableLiveData<MutableList<TVShowData>> {
        val tvShowList = MutableLiveData<MutableList<TVShowData>>()
        remoteDataSource.fetchTVShowData(object : RemoteDataSource.LoadTVShowsCallback {
            override fun onAllTVShowReceived(tvShowResponses: MutableList<TVShowData>) {
                tvShowList.value = tvShowResponses
            }
        })
        return tvShowList
    }

}