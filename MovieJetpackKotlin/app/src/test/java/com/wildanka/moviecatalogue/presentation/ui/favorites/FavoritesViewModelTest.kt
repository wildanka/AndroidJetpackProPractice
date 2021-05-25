package com.wildanka.moviecatalogue.presentation.ui.favorites

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.wildanka.moviecatalogue.data.FavoritesRepository
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoritesViewModelTest {
    private lateinit var viewModel: FavoritesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var favoriteRepository: FavoritesRepository

    @Mock
    private lateinit var movieRepository: MoviesRepository

    @Mock
    private lateinit var observer: Observer<PagedList<FavoriteMovie>>

    @Mock
    private lateinit var pagedList: PagedList<FavoriteMovie>

    @Before
    fun setUp() {
        favoriteRepository = mock(FavoritesRepository::class.java)
        viewModel = FavoritesViewModel(favoriteRepository, movieRepository)
    }

    @Test
    fun `get favorite movies`() {
        val dummyMovie = pagedList
        `when`(dummyMovie.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<FavoriteMovie>>()
        movie.value = dummyMovie

        `when`(favoriteRepository.getFavoriteMovies()).thenReturn(movie)
        val movieEntities = viewModel.getAllFavoriteMoviePaging().value
        verify(favoriteRepository).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getAllFavoriteMoviePaging().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

  @Test
    fun `get favorite tv show`() {
        val dummyMovie = pagedList
        `when`(dummyMovie.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<FavoriteMovie>>()
        movie.value = dummyMovie

        `when`(favoriteRepository.getFavoriteMovies()).thenReturn(movie)
        val movieEntities = viewModel.getAllFavoriteMoviePaging().value
        verify(favoriteRepository).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getAllFavoriteMoviePaging().observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }

    @Test
    fun getMovieDetail() {
        val idMovie = "460465"
        val dummyMovie = DataDummy.generateLocalDummyFavoriteMovieDetail()
        val movie = MutableLiveData<FavoriteMovie>()
        movie.value = dummyMovie

        `when`(favoriteRepository.getFavoriteMovieDetails(idMovie)).thenReturn(movie)
        val favoriteMovieEntity = viewModel.getFavoriteMoviesDetails(idMovie)?.value
        verify(favoriteRepository).getFavoriteMovieDetails(idMovie)

        assertNotNull(favoriteMovieEntity)
        assertEquals(dummyMovie.title, favoriteMovieEntity?.title)
    }

    @Test
    fun getTVShowDetail() {
        val idTVShow = "460465"
        val dummyTVShow = DataDummy.generateLocalDummyFavoriteTVShowDetail()
        val tvShow = MutableLiveData<FavoriteTVShow>()
        tvShow.value = dummyTVShow

        `when`(favoriteRepository.getFavoriteTvShowDetail(idTVShow)).thenReturn(tvShow)
        val favoriteTVShowEntity = viewModel.getFavoriteTVShowDetails(idTVShow)?.value
        verify(favoriteRepository).getFavoriteTvShowDetail(idTVShow)

        assertNotNull(favoriteTVShowEntity)
        assertEquals(dummyTVShow.title, favoriteTVShowEntity?.title)
    }
}