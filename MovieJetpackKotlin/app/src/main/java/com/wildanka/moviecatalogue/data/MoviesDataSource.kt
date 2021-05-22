package com.wildanka.moviecatalogue.data

import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowDetail
import com.wildanka.moviecatalogue.domain.entity.MovieCredits
import com.wildanka.moviecatalogue.domain.entity.MovieDetail

interface MoviesDataSource {
    fun fetchMovieData(): MutableLiveData<MutableList<MovieData>>
    fun fetchMovieDataDetail(movieId: String): MutableLiveData<MovieDetail>
    fun fetchMovieDetailCredits(movieId: String): MutableLiveData<MovieCredits>
    fun searchMovies(query: String): MutableLiveData<MutableList<MovieData>>

    fun fetchTVShowData(): MutableLiveData<MutableList<TVShowData>>
    fun fetchTvShowDataDetail(tvShowId: String): MutableLiveData<TVShowDetail>
    fun fetchTVShowDetailCredits(tvShowId: String): MutableLiveData<MovieCredits>
    fun searchTVShows(query: String): MutableLiveData<MutableList<TVShowData>>

}