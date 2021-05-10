package com.wildanka.moviecatalogue.presentation.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.wildanka.moviecatalogue.data.FavoritesRepository
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.domain.entity.MovieCredits
import com.wildanka.moviecatalogue.domain.entity.MovieDetail
import com.wildanka.moviecatalogue.domain.entity.TVShowDetail
import com.wildanka.moviecatalogue.util.MovieDetailConverter

class FavoritesViewModel(private val favoritesRepository: FavoritesRepository) : ViewModel() {
    private var repo = MoviesRepository()
    private var favoriteMovieLiveData: LiveData<FavoriteMovie>? = null
    private var favoritTVShowLiveData: LiveData<FavoriteTVShow>? = null

    //region local
    fun checkIsFavorite(movieID: String): LiveData<FavoriteMovie>? {
        favoriteMovieLiveData = favoritesRepository.getFavoriteMovieDetails(movieID)
        return favoriteMovieLiveData
    }

    fun getAllFavoriteMoviePaging(): LiveData<PagedList<FavoriteMovie>> {
        return favoritesRepository.getFavoriteMovies()
    }

    fun insertFavoriteMovieData(movie: MovieDetail) {
        //convert MovieDetail to MovieFavorites
        val favoriteMovie = MovieDetailConverter.convertToTVShowFavorites(movie)
        favoritesRepository.insertMovie(favoriteMovie)
    }

    fun insertFavoriteMovie(favoriteMovie: FavoriteMovie) {
        favoritesRepository.insertMovie(favoriteMovie)
    }

    fun removeFavoriteMovieData(movie: MovieDetail) {
        val favoriteMovie = MovieDetailConverter.convertToTVShowFavorites(movie)
        favoritesRepository.deleteMovie(favoriteMovie)
    }

    fun removeFavoriteMovie(favoriteMovie: FavoriteMovie) {
        favoritesRepository.deleteMovie(favoriteMovie)
    }

    fun getFavoriteMoviesDetails(movieId: String): LiveData<FavoriteMovie>? {
        if (favoriteMovieLiveData == null) favoriteMovieLiveData = favoritesRepository.getFavoriteMovieDetails(movieId)
        return favoriteMovieLiveData
    }
    //endregion local

    //region local TV Show
    fun checkIsFavoriteTVShow(tvShowId: String): LiveData<FavoriteTVShow>? {
        favoritTVShowLiveData = favoritesRepository.getFavoriteTvShowDetail(tvShowId)
        return favoritTVShowLiveData
    }

    fun getAllFavoriteTVShowPaging(): LiveData<PagedList<FavoriteTVShow>> {
        return favoritesRepository.getFavoriteTVShows()
    }

    fun insertFavoriteTVShowData(tvShow: TVShowDetail) {
        //convert MovieDetail to MovieFavorites
        val favoriteTvShow = MovieDetailConverter.convertToTVShowFavorites(tvShow)
        favoritesRepository.insertTVShow(favoriteTvShow)
    }

    fun insertFavoriteTVShow(favoriteTVShow: FavoriteTVShow) {
        favoritesRepository.insertTVShow(favoriteTVShow)
    }

    fun removeFavoriteTVShowData(tvShow: TVShowDetail) {
        val favoriteTvShow= MovieDetailConverter.convertToTVShowFavorites(tvShow)
        favoritesRepository.deleteTVShow(favoriteTvShow)
    }

    fun removeFavoriteTVShow(favoriteTVShow: FavoriteTVShow) {
        favoritesRepository.deleteTVShow(favoriteTVShow)
    }

    fun getFavoriteTVShowDetails(movieId: String): LiveData<FavoriteTVShow>? {
        if (favoritTVShowLiveData == null) favoritTVShowLiveData = favoritesRepository.getFavoriteTvShowDetail(movieId)
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