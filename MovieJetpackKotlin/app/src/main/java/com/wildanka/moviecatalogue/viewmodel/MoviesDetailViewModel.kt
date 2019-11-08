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
        if (movieDetail == null) movieDetail = repo.fetchMovieDataDetail(movieId)
        return movieDetail
    }
    fun getMoviesCastData(movieId: String?): MutableLiveData<MovieCredits>? {
        if (movieCredits == null) movieCredits = repo.fetchMovieDetailCredits(movieId)
        return movieCredits
    }

    fun getTVShowAtIndex(tvShowId: String?): MutableLiveData<TVShowDetail>? {
        if (tvShowDetail == null) tvShowDetail = repo.fetchTvShowDataDetail(tvShowId)
        return tvShowDetail
    }

    fun getTVShowCastData(tvShowId: String?): MutableLiveData<MovieCredits>? {
        if (movieCredits == null) movieCredits = repo.fetchTVShowDetailCredits(tvShowId)
        return movieCredits
    }
}