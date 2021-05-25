package com.wildanka.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wildanka.moviecatalogue.data.datasource.local.LocalDataSource
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.util.AppExecutors


class FavoritesRepository(
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : FavoritesDataSource {

    companion object {
        @Volatile
        private var instance: FavoritesRepository? = null

        fun getInstance(
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): FavoritesRepository =
            instance ?: synchronized(this) {
                FavoritesRepository(localData, appExecutors).apply {
                    instance = this
                }
            }
    }


    //using FavoritesDataSource
    override fun getFavoriteMovies(): LiveData<PagedList<FavoriteMovie>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteMovieDetails(movieId: String): LiveData<FavoriteMovie> {
        return localDataSource.getFavoriteMovieDetail(movieId)
    }

    override fun insertMovie(favoriteMovie: FavoriteMovie) {
        appExecutors.diskIO().execute { localDataSource.insertFavoriteMovie(favoriteMovie) }
    }

    override fun deleteMovie(favoriteMovie: FavoriteMovie) {
        appExecutors.diskIO().execute { localDataSource.deleteFavoriteMovie(favoriteMovie) }
    }


    override fun getFavoriteTVShows(): LiveData<PagedList<FavoriteTVShow>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTVShows(), config).build()
    }

    override fun getFavoriteTvShowDetail(movieId: String): LiveData<FavoriteTVShow> {
        return localDataSource.getFavoriteTVShowDetail(movieId)
    }

    override fun insertTVShow(favoriteTVShowData: FavoriteTVShow) {
        appExecutors.diskIO().execute { localDataSource.insertFavoriteTVShow(favoriteTVShowData) }
    }

    override fun deleteTVShow(favoriteTVShowData: FavoriteTVShow) {
        appExecutors.diskIO().execute { localDataSource.deleteFavoriteTVShow(favoriteTVShowData) }
    }


}