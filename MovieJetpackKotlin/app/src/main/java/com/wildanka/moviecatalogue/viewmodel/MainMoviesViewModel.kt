package com.wildanka.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.entity.Movie
import com.wildanka.moviecatalogue.entity.TvShow

class MainMoviesViewModel : ViewModel(){
    private val movieList = mutableListOf<Movie>()
    private val tvShowList = mutableListOf<TvShow>()

    fun getMovieList() : MutableList<Movie>{
        return movieList
    }

    fun addMovieList(movie : Movie){
        movieList.add(movie)
    }

    fun getTVShowList() : MutableList<TvShow>{
        return tvShowList
    }

    fun addTVShowList(tvShow : TvShow){
        tvShowList.add(tvShow)
    }
}