package com.wildanka.moviecatalogue.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.entity.*

class MoviesDetailViewModel : ViewModel() {
    private val repo = MoviesRepository()
    private var movieDetail : MutableLiveData<MovieDetail>? = null
    private var movieCredits : MutableLiveData<MovieCredits>? = null
    private var tvShowDetail : MutableLiveData<TVShowDetail>? = null

    fun getMoviesAtIndex(movieId: String?): MutableLiveData<MovieDetail>? {
        movieDetail = repo.fetchMovieDataDetail(movieId)
        return movieDetail
    }
    fun getMoviesCastData(movieId: String?): MutableLiveData<MovieCredits>? {
        movieCredits = repo.fetchMovieDetailCredits(movieId)
        return movieCredits
    }

    fun getTVShowAtIndex(tvShowId: String?): MutableLiveData<TVShowDetail>? {
        tvShowDetail = repo.fetchTvShowDataDetail(tvShowId)
        return tvShowDetail
    }

    fun getTVShowCastData(tvShowId: String?): MutableLiveData<MovieCredits>? {
        movieCredits = repo.fetchTVShowDetailCredits(tvShowId)
        return movieCredits
    }
}