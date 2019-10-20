package com.wildanka.moviecatalogue

import androidx.lifecycle.ViewModel

class MainMoviesViewModel : ViewModel(){
    private val movieList = mutableListOf<Movie>()

    fun getMovieList() : MutableList<Movie>{
        return movieList
    }

    fun addMovieList(movie : Movie){
        movieList.add(movie)
    }
}