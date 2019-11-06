package com.wildanka.moviecatalogue.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.entity.MovieData
import com.wildanka.moviecatalogue.model.entity.TVShowData

class MainMoviesViewModel : ViewModel(){
    private val repo = MoviesRepository()
    private var movieList : MutableLiveData<MutableList<MovieData>>? = null
    private var tvShowList : MutableLiveData<MutableList<TVShowData>>? = null

    fun getMovieList() : MutableLiveData<MutableList<MovieData>>? {
        movieList = repo.fetchMovieData()
        return movieList
    }

    fun getTVShowList() : MutableLiveData<MutableList<TVShowData>>? {
        tvShowList = repo.fetchTvShowData()
        return tvShowList
    }

}