package com.wildanka.moviecatalogue.favorite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wildanka.moviecatalogue.remote.repository.MoviesRepository
import com.wildanka.moviecatalogue.favorite.model.entity.FavoriteMovie
import com.wildanka.moviecatalogue.favorite.model.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.favorite.repo.FavoritesRepository
import com.wildanka.moviecatalogue.remote.model.entity.*
import com.wildanka.moviecatalogue.util.MovieDetailConverter

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private var favoritesRepository = FavoritesRepository(application)
    private var repo = MoviesRepository()
    private var favoriteMovieLiveData: LiveData<FavoriteMovie>? = null
    private var favoritTVShowLiveData: LiveData<FavoriteTVShow>? = null

    //region local
    fun checkIsFavorite(movieID: String): LiveData<FavoriteMovie>? {
        favoriteMovieLiveData = favoritesRepository.getFavoriteMoviesDetails(movieID)
        return favoriteMovieLiveData
    }

    fun getAllFavoriteMoviePaging(): LiveData<PagedList<FavoriteMovie>> {
        return LivePagedListBuilder(favoritesRepository.getAllFavoriteMoviePaging()!!, 5).build()
    }

    fun insertFavoriteMovieData(movie: MovieDetail) {
        //convert MovieDetail to MovieFavorites
        val favoriteMovie = MovieDetailConverter.convertToTVShowFavorites(movie)
        favoritesRepository.addToFavoriteMovies(favoriteMovie)
    }

    fun insertFavoriteMovie(favoriteMovie: FavoriteMovie) {
        favoritesRepository.addToFavoriteMovies(favoriteMovie)
    }

    fun removeFavoriteMovieData(movie: MovieDetail) {
        val favoriteMovie = MovieDetailConverter.convertToTVShowFavorites(movie)
        favoritesRepository.removeFromFavoriteMovies(favoriteMovie)
    }

    fun removeFavoriteMovie(favoriteMovie: FavoriteMovie) {
        favoritesRepository.removeFromFavoriteMovies(favoriteMovie)
    }

    fun getFavoriteMoviesDetails(movieId: String?): LiveData<FavoriteMovie>? {
        if (favoriteMovieLiveData == null) favoriteMovieLiveData = favoritesRepository.getFavoriteMoviesDetails(movieId)
        return favoriteMovieLiveData
    }
    //endregion local

    //region local TV Show
    fun checkIsFavoriteTVShow(tvShowId: String): LiveData<FavoriteTVShow>? {
        favoritTVShowLiveData = favoritesRepository.getFavoriteTVShowDetails(tvShowId)
        return favoritTVShowLiveData
    }

    fun getAllFavoriteTVShowPaging(): LiveData<PagedList<FavoriteTVShow>> {
        return LivePagedListBuilder(favoritesRepository.getAllFavoriteTVShowPaging()!!, 5).build()
    }

    fun insertFavoriteTVShowData(tvShow: TVShowDetail) {
        //convert MovieDetail to MovieFavorites
        val favoriteTvShow= MovieDetailConverter.convertToTVShowFavorites(tvShow)
        favoritesRepository.addToFavoriteTVShow(favoriteTvShow)
    }

    fun insertFavoriteTVShow(favoriteTVShow: FavoriteTVShow) {
        favoritesRepository.addToFavoriteTVShow(favoriteTVShow)
    }

    fun removeFavoriteTVShowData(tvShow: TVShowDetail) {
        val favoriteTvShow= MovieDetailConverter.convertToTVShowFavorites(tvShow)
        favoritesRepository.removeFromFavoriteTVShow(favoriteTvShow)
    }

    fun removeFavoriteTVShow(favoriteTVShow: FavoriteTVShow) {
        favoritesRepository.removeFromFavoriteTVShow(favoriteTVShow)
    }

    fun getFavoriteTVShowDetails(movieId: String?): LiveData<FavoriteTVShow>? {
        if (favoritTVShowLiveData == null) favoritTVShowLiveData = favoritesRepository.getFavoriteTVShowDetails(
            movieId
        )
        return favoritTVShowLiveData
    }
    //endregion local TV Show

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