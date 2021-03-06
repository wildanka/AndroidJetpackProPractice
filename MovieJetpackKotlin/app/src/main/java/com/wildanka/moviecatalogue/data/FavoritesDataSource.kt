package com.wildanka.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow

interface FavoritesDataSource {
    fun getFavoriteMovies(): LiveData<PagedList<FavoriteMovie>>
    fun getFavoriteMovieDetails(movieId: String): LiveData<FavoriteMovie>
    fun insertMovie(favoriteMovie: FavoriteMovie)
    fun deleteMovie(favoriteMovie: FavoriteMovie)

    fun getFavoriteTVShows(): LiveData<PagedList<FavoriteTVShow>>
    fun getFavoriteTvShowDetail(movieId: String): LiveData<FavoriteTVShow>
    fun insertTVShow(favoriteTVShowData: FavoriteTVShow)
    fun deleteTVShow(favoriteTVShowData: FavoriteTVShow)
}