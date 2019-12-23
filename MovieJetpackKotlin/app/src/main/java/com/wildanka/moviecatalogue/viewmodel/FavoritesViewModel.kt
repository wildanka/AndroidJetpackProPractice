package com.wildanka.moviecatalogue.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.db.FavoritesRepository
import com.wildanka.moviecatalogue.model.entity.*

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private var favoritesRepository = FavoritesRepository(application)
    private var repo = MoviesRepository()
    private var favoriteMovieLiveData: LiveData<FavoriteMovie>? = null

    //region local
    fun checkIsFavorite(movieID: String): LiveData<FavoriteMovie>? {
        favoriteMovieLiveData = favoritesRepository?.getFavoriteMoviesDetails(movieID)
        return favoriteMovieLiveData
    }

    fun getAllFavoritesMovies() : LiveData<List<FavoriteMovie>>? {
        return favoritesRepository?.getAllFavoriteMovies()
    }

    fun insertFavoriteMovieData(movie: MovieDetail) {
        //convert MovieDetail to MovieFavorites
        val favoriteMovie = MovieDetailConverter.convertToMovieFavorites(movie)
        favoritesRepository?.addToFavoriteMovies(favoriteMovie)
    }

    fun removeFavoriteMovieData(movie: MovieDetail) {
        val favoriteMovie = MovieDetailConverter.convertToMovieFavorites(movie)
        favoritesRepository?.removeFromFavoriteMovies(favoriteMovie)
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