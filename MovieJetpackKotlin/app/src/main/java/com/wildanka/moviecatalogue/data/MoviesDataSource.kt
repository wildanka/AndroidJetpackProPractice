package com.wildanka.moviecatalogue.data

import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData

interface MoviesDataSource {
    fun fetchMovieData(): MutableLiveData<MutableList<MovieData>>

    fun fetchTVShowData(): MutableLiveData<MutableList<TVShowData>>

}