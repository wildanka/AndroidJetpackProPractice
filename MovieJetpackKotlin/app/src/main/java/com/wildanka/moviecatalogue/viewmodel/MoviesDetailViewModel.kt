package com.wildanka.moviecatalogue.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.entity.*

class MoviesDetailViewModel : ViewModel() {
    private val repo = MoviesRepository()
    private var movieDetail : MutableLiveData<MovieData>? = null
    private var tvShowDetail : MutableLiveData<TVShowData>? = null

    fun getMoviesAtIndex(movieId: Int): MutableLiveData<MovieData>? {
        movieDetail = repo.fetchMovieDataDetail()
        return movieDetail
    }

    fun getTVShowAtIndex(tvShowId: Int): MutableLiveData<TVShowData>? {
        tvShowDetail = repo.fetchTvShowDataDetail()
        return tvShowDetail
    }

}