package com.wildanka.moviecatalogue.presentation.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.domain.entity.TVShowData

class MainMoviesViewModel : ViewModel(){
    private var repo = MoviesRepository()
    private var movieList : MutableLiveData<MutableList<MovieData>>? = null
    private var tvShowList : MutableLiveData<MutableList<TVShowData>>? = null

    fun getMovieList() : MutableLiveData<MutableList<MovieData>>? {
        if (movieList == null) movieList = repo.fetchMovieData()
        return movieList
    }

    fun getTVShowList() : MutableLiveData<MutableList<TVShowData>>? {
        if (tvShowList == null) tvShowList = repo.fetchTvShowData()
        return tvShowList
    }
}