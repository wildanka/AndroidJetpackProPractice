package com.wildanka.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.entity.Movie
import com.wildanka.moviecatalogue.entity.TvShow

class MainMoviesViewModel : ViewModel(){
    private val repo = MoviesRepository()
    private var movieList : MutableList<Movie>? = null
    private var tvShowList : MutableList<TvShow>? = null

    fun getMovieList() : MutableList<Movie>? {
        movieList = repo.getAllMovies()
        return movieList
    }

    fun getTVShowList() : MutableList<TvShow>? {
        tvShowList = repo.getAllTVShow()
        return tvShowList
    }

}