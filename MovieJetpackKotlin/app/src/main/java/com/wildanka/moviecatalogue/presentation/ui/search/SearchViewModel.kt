package com.wildanka.moviecatalogue.presentation.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData

class SearchViewModel : ViewModel() {
    private var repo = MoviesRepository()
    private var movieList : MutableLiveData<MutableList<MovieData>>? = null
    private var tvShowList : MutableLiveData<MutableList<TVShowData>>? = null

    fun getSearchedMovies(query: String) : MutableLiveData<MutableList<MovieData>>? {
        movieList = repo.searchMovies(query)
        return movieList
    }

    fun getSearchedTVShows(query: String) : MutableLiveData<MutableList<TVShowData>>? {
        tvShowList = repo.searchTVShows(query)
        return tvShowList
    }

}