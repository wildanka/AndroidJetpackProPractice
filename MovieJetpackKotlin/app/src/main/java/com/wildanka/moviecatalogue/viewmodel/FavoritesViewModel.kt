package com.wildanka.moviecatalogue.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.db.FavoritesRepository
import com.wildanka.moviecatalogue.model.db.MovieCatalogueDatabase
import com.wildanka.moviecatalogue.model.entity.*

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private var favoritesRepository = FavoritesRepository(application)
    private var repo = MoviesRepository()
    private var favoriteMovieLiveData: LiveData<MovieFavorites>? = null

    //region local
    fun checkIsFavorite(movieID: String): LiveData<MovieFavorites>? {
        favoriteMovieLiveData = favoritesRepository?.getFavoriteMoviesDetails(movieID)
        return favoriteMovieLiveData
    }

    fun getAllFavoritesMovies() : LiveData<List<MovieFavorites>>? {
        return favoritesRepository?.getAllFavoriteMovies()
    }

    fun insertFavoriteMovieData(movie: MovieDetail) {
        //convert MovieDetail to MovieFavorites
        val genreList : String? = movie.genres.joinToString()
        val favoriteMovies = MovieFavorites(
            movie.idMovie,
            movie.adult,
            movie.backdropPath,
            genreList,
            movie.homePageUrl,
            movie.originalLanguage,
            movie.overview,
            movie.popularity,
            movie.posterPath,
            movie.releaseDate,
            movie.revenue,
            movie.duration,
            movie.status,
            movie.tagline,
            movie.title,
            movie.voteAverage,
            movie.voteCount
        )

        favoritesRepository?.addToFavoriteMovies(favoriteMovies)
    }

    fun removeFavoriteMovieData(movies: MovieFavorites) {
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