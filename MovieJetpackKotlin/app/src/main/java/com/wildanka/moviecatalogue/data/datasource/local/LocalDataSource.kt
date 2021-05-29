package com.wildanka.moviecatalogue.data.datasource.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieCast

class LocalDataSource private constructor(private val mFavoritesDao: FavoritesDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(favoritesDao: FavoritesDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(favoritesDao).apply {
                INSTANCE = this
            }
    }

    fun getFavoriteMovies(): DataSource.Factory<Int, FavoriteMovie> = mFavoritesDao.getAllFavoriteMoviePaging()
    fun getFavoriteMovieDetail(movieId: String): LiveData<FavoriteMovie> = mFavoritesDao.getFavoriteMovieDetails(movieId)
    fun getFavoriteMovieCasts(movieId: String): LiveData<List<MovieCast>> = mFavoritesDao.getFavoriteMovieCasts(movieId)
    fun insertFavoriteMovie(movie: FavoriteMovie) = mFavoritesDao.insertFavoriteMovie(movie)
    fun insertFavoriteMovieCasts(movieCasts: List<MovieCast>) = mFavoritesDao.insertFavoriteMovieCasts(movieCasts)
    fun deleteFavoriteMovie(movie: FavoriteMovie) = mFavoritesDao.deleteFavoriteMovie(movie)

    fun getFavoriteTVShows(): DataSource.Factory<Int, FavoriteTVShow> = mFavoritesDao.getAllFavoriteTVShowPaging()
    fun getFavoriteTVShowDetail(tvShowId: String): LiveData<FavoriteTVShow> = mFavoritesDao.getFavoriteTVShowDetails(tvShowId)
    fun insertFavoriteTVShow(tvShow: FavoriteTVShow) = mFavoritesDao.insertFavoriteTVShow(tvShow)
    fun deleteFavoriteTVShow(tvShow: FavoriteTVShow) = mFavoritesDao.deleteFavoriteTVShow(tvShow)

}