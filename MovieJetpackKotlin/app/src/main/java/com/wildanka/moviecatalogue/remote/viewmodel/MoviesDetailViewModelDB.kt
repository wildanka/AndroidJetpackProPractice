package com.wildanka.moviecatalogue.remote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.favorite.repo.FavoritesRepository
import com.wildanka.moviecatalogue.remote.repository.MoviesRepository
import com.wildanka.moviecatalogue.remote.model.entity.MovieCredits
import com.wildanka.moviecatalogue.remote.model.entity.MovieDetail
import com.wildanka.moviecatalogue.remote.model.entity.TVShowDetail

class MoviesDetailViewModelDB(application: Application) : AndroidViewModel(application) {
    private val repo = MoviesRepository()
    private val localRepo = FavoritesRepository(application)
    private var movieDetail : MutableLiveData<MovieDetail>? = null
    private var movieCredits : MutableLiveData<MovieCredits>? = null
    private var tvShowDetail : MutableLiveData<TVShowDetail>? = null


    fun getMoviesDetailWithID(movieId: String?): MutableLiveData<MovieDetail>? {
        if (movieDetail == null) movieDetail = repo.fetchMovieDataDetail(movieId)
        return movieDetail
    }
    fun getMoviesCastData(movieId: String?): MutableLiveData<MovieCredits>? {
        if (movieCredits == null) movieCredits = repo.fetchMovieDetailCredits(movieId)
        return movieCredits
    }

    fun getTVShowDetailWithId(tvShowId: String?): MutableLiveData<TVShowDetail>? {
        if (tvShowDetail == null) tvShowDetail = repo.fetchTvShowDataDetail(tvShowId)
        return tvShowDetail
    }

    fun getTVShowCastData(tvShowId: String?): MutableLiveData<MovieCredits>? {
        if (movieCredits == null) movieCredits = repo.fetchTVShowDetailCredits(tvShowId)
        return movieCredits
    }
}