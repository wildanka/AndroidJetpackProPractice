package com.wildanka.moviecatalogue.presentation.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.domain.entity.MovieCredits
import com.wildanka.moviecatalogue.domain.entity.MovieDetail
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowDetail

class MoviesDetailViewModel(private val repo: MoviesRepository) : ViewModel() {
    private var movieDetail : MutableLiveData<MovieDetail>? = null
    private var movieCredits : MutableLiveData<MovieCredits>? = null
    private var tvShowDetail : MutableLiveData<TVShowDetail>? = null

    fun getMoviesDetailWithID(movieId: String): MutableLiveData<MovieDetail>? {
        if (movieDetail == null) movieDetail = repo.fetchMovieDataDetail(movieId)
        return movieDetail
    }
    fun getMoviesCastData(movieId: String): MutableLiveData<MovieCredits>? {
        if (movieCredits == null) movieCredits = repo.fetchMovieDetailCredits(movieId)
        return movieCredits
    }

    fun getTVShowDetailWithId(tvShowId: String): MutableLiveData<TVShowDetail>? {
        if (tvShowDetail == null) tvShowDetail = repo.fetchTvShowDataDetail(tvShowId)
        return tvShowDetail
    }

    fun getTVShowCastData(tvShowId: String): MutableLiveData<MovieCredits>? {
        if (movieCredits == null) movieCredits = repo.fetchTVShowDetailCredits(tvShowId)
        return movieCredits
    }
}