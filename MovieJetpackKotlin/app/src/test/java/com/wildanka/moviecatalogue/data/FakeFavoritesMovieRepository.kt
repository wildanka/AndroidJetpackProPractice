package com.wildanka.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.wildanka.moviecatalogue.favorite.model.db.FavoritesDao
import com.wildanka.moviecatalogue.favorite.model.db.FavoritesDao_Impl
import com.wildanka.moviecatalogue.favorite.model.db.MovieCatalogueDatabase
import com.wildanka.moviecatalogue.favorite.model.entity.FavoriteMovie
import com.wildanka.moviecatalogue.favorite.model.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.util.AppExecutors

class FakeFavoritesMovieRepository constructor(
    private val localDataSource: MovieCatalogueDatabase,
    private val appExecutors: AppExecutors
): FavoritesDao{
    override fun getAllFavoriteMovies(): LiveData<List<FavoriteMovie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavoriteMovieDetails(idMovie: String?): LiveData<FavoriteMovie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertFavoriteMovie(movieDataFavorite: FavoriteMovie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteFavoriteMovie(movieDataFavorite: FavoriteMovie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllFavoriteTVShow(): LiveData<List<FavoriteTVShow>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavoriteTVShowDetails(idTVShow: String?): LiveData<FavoriteTVShow> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertFavoriteTVShow(movieDataFavorite: FavoriteTVShow) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteFavoriteTVShow(movieDataFavorite: FavoriteTVShow) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllFavoritTVShowPaging(): DataSource.Factory<Int, FavoriteTVShow> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllFavoritMoviePaging(): DataSource.Factory<Int, FavoriteMovie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}