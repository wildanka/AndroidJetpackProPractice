package com.wildanka.moviecatalogue.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.entity.Movie
import com.wildanka.moviecatalogue.entity.TvShow

class MoviesDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = MoviesRepository(application)
    private var movieList : MutableList<Movie>? = null
    private var tvShowList : MutableList<TvShow>? = null

    fun getMoviesAtIndex(index: Int): Movie? {
        movieList = repo.getAllMovies()
        return movieList!![index]
    }

    fun getTVShowAtIndex(index: Int): TvShow? {
        tvShowList = repo.getAllTVShow()
        return tvShowList!![index]
    }

}