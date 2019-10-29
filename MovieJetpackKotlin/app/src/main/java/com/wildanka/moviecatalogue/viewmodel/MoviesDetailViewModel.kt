package com.wildanka.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.entity.Movie
import com.wildanka.moviecatalogue.model.entity.TvShow

class MoviesDetailViewModel : ViewModel() {
    private val repo = MoviesRepository()
    private var movieList : MutableList<Movie>? = null
    private var tvShowList : MutableList<TvShow>? = null

    fun getMoviesAtIndex(index: Int): Movie? {
        movieList = repo.getAllMovies()
        return movieList?.get(index)
    }

    fun getTVShowAtIndex(index: Int): TvShow? {
        tvShowList = repo.getAllTVShow()
        return tvShowList?.get(index)
    }

}