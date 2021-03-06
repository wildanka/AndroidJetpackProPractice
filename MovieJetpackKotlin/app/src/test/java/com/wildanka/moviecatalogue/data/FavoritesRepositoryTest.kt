package com.wildanka.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.wildanka.moviecatalogue.data.datasource.local.LocalDataSource
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.util.AppExecutors
import com.wildanka.moviecatalogue.util.DataDummy
import com.wildanka.moviecatalogue.util.LiveDataTestUtil
import com.wildanka.moviecatalogue.util.PagedListUtil
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class FavoritesRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutors = Mockito.mock(AppExecutors::class.java)

    private val favoriteRepository = FakeFavoritesRepository(local, appExecutors)
    private val favoriteMovieId = "460465"
    private val favoriteMovie = DataDummy.generateLocalDummyFavoriteMovies()
    private val favoriteTVShowId = "88396"
    private val favoriteTVShow = DataDummy.generateLocalDummyFavoriteTVShow()

    @Test
    fun getFavoriteMovies(){
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteMovie>
        Mockito.`when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        favoriteRepository.getFavoriteMovies()

        val dummyMovies = PagedListUtil.mockPagedList(DataDummy.generateLocalDummyFavoriteMovies())
        verify(local).getFavoriteMovies()
        assertNotNull(dummyMovies)
        assertEquals(dummyMovies.size.toLong(), dummyMovies.size.toLong())
    }

    @Test
    fun getFavoriteTvShow(){
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteTVShow>
        Mockito.`when`(local.getFavoriteTVShows()).thenReturn(dataSourceFactory)
        favoriteRepository.getFavoriteTVShows()

        val dummyTVShow = PagedListUtil.mockPagedList(DataDummy.generateLocalDummyFavoriteMovies())
        verify(local).getFavoriteTVShows()
        assertNotNull(dummyTVShow)
        assertEquals(dummyTVShow.size.toLong(), dummyTVShow.size.toLong())
    }


    @Test
    fun getFavoriteMovieDetail(){
        val dummyMovies = MutableLiveData<FavoriteMovie>()
        dummyMovies.value = DataDummy.generateLocalDummyMovieDetail()
        Mockito.`when`<LiveData<FavoriteMovie>>(local.getFavoriteMovieDetail(favoriteMovieId)).thenReturn(dummyMovies)

        val favoriteMovie = LiveDataTestUtil.getValue(favoriteRepository.getFavoriteMovieDetails(favoriteMovieId))
        verify(local).getFavoriteMovieDetail(favoriteMovieId)
        assertNotNull(favoriteMovie)
        assertEquals(this.favoriteMovie[0].title, favoriteMovie.title)
    }

    @Test
    fun getFavoriteTvShowDetail(){
        val dummyMovies = MutableLiveData<FavoriteTVShow>()
        dummyMovies.value = DataDummy.generateLocalDummyTVShowDetail()
        Mockito.`when`<LiveData<FavoriteTVShow>>(local.getFavoriteTVShowDetail(favoriteMovieId)).thenReturn(dummyMovies)

        val favoriteTvShow = LiveDataTestUtil.getValue(favoriteRepository.getFavoriteTvShowDetail(favoriteMovieId))
        verify(local).getFavoriteTVShowDetail(favoriteMovieId)
        assertNotNull(favoriteTvShow)
        assertEquals(this.favoriteTVShow[0].title, favoriteTvShow.title)
    }
}