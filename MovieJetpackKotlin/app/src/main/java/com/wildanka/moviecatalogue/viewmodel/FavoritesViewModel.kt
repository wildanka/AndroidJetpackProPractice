package com.wildanka.moviecatalogue.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.db.FavoritesRepository
import com.wildanka.moviecatalogue.model.entity.*

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private var favoritesRepository = FavoritesRepository(application)
    private var repo = MoviesRepository()
    private var favoriteMovieLiveData: LiveData<FavoriteMovie>? = null
    private var favoritTVShowLiveData: LiveData<FavoriteTVShow>? = null

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
        val favoriteMovie = MovieDetailConverter.convertToTVShowFavorites(movie)
        favoritesRepository?.addToFavoriteMovies(favoriteMovie)
    }

    fun removeFavoriteMovieData(movie: MovieDetail) {
        val favoriteMovie = MovieDetailConverter.convertToTVShowFavorites(movie)
        favoritesRepository?.removeFromFavoriteMovies(favoriteMovie)
    }
    //endregion local

    //region local TV Show
    fun checkIsFavoriteTVShow(tvShowId: String): LiveData<FavoriteTVShow>? {
        favoritTVShowLiveData = favoritesRepository?.getFavoriteTVShowDetails(tvShowId)
        return favoritTVShowLiveData
    }

    fun getAllFavoritesTvShow() : LiveData<List<FavoriteTVShow>>? {
        return favoritesRepository?.getAllFavoriteTVShow()
    }

    fun insertFavoriteTVShowData(tvShow: TVShowDetail) {
        //convert MovieDetail to MovieFavorites
        val favoriteTvShow= MovieDetailConverter.convertToTVShowFavorites(tvShow)
        favoritesRepository?.addToFavoriteTVShow(favoriteTvShow)
    }

    fun removeFavoriteTVShowData(tvShow: TVShowDetail) {
        val favoriteTvShow= MovieDetailConverter.convertToTVShowFavorites(tvShow)
        favoritesRepository?.removeFromFavoriteTVShow(favoriteTvShow)
    }
    //endregion local TV Show

    //region paging
    fun getAllFavoriteTVShowPaging(): LiveData<PagedList<FavoriteTVShow>> {
        return LivePagedListBuilder(favoritesRepository.getAllFavoriteTVShowPaging()!!,5).build()
    }
    //endregion paging

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