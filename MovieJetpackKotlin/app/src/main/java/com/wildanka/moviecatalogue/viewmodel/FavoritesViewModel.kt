package com.wildanka.moviecatalogue.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.db.FavoritesRepository
import com.wildanka.moviecatalogue.model.db.MovieCatalogueDatabase
import com.wildanka.moviecatalogue.model.entity.MovieCredits
import com.wildanka.moviecatalogue.model.entity.MovieData
import com.wildanka.moviecatalogue.model.entity.MovieDetail
import com.wildanka.moviecatalogue.model.entity.TVShowDetail

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private var favoritesRepository = FavoritesRepository(application)
    private var repo = MoviesRepository()
    private var favoriteMovieLiveData: LiveData<MovieData>? = null

    //region local
    fun checkIsFavorite(movieID: String): LiveData<MovieData>? {
        favoriteMovieLiveData = favoritesRepository?.getFavoriteMoviesDetails(movieID)
        return favoriteMovieLiveData
    }

    fun getAllFavoritesMovies() : LiveData<List<MovieData>>? {
        return favoritesRepository?.getAllFavoriteMovies()
    }

    fun insertFavoriteMovieData(movie: MovieData) {
        favoritesRepository?.addToFavoriteMovies(movie)
    }

    fun removeFavoriteMovieData(movies: MovieData) {
        favoritesRepository?.removeFromFavoriteMovies(movies)
    }
    //endregion local

    //region online
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
    //endregion online

}