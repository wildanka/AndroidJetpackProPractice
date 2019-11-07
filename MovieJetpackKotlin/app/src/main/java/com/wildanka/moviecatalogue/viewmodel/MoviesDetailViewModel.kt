package com.wildanka.moviecatalogue.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.entity.MovieData
import com.wildanka.moviecatalogue.model.entity.MovieDetail
import com.wildanka.moviecatalogue.model.entity.TVShowData

class MoviesDetailViewModel : ViewModel() {
    private val repo = MoviesRepository()
    private var movieDetail : MutableLiveData<MovieDetail>? = null
    private var tvShowDetail : MutableLiveData<TVShowData>? = null

    fun getMoviesAtIndex(movieId: String?): MutableLiveData<MovieDetail>? {
        movieDetail = repo.fetchMovieDataDetail(movieId)
        return movieDetail
    }

    fun getTVShowAtIndex(tvShowId: String?): MutableLiveData<TVShowData>? {
        tvShowDetail = repo.fetchTvShowDataDetail(tvShowId)
        return tvShowDetail
    }

}