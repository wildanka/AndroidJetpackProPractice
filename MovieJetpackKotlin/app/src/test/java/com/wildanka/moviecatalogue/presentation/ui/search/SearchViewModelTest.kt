package com.wildanka.moviecatalogue.presentation.ui.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData
import com.wildanka.moviecatalogue.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class SearchViewModelTest {
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var searchViewModel: SearchViewModel

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setUp() {
        moviesRepository = Mockito.mock(MoviesRepository::class.java)
        searchViewModel =
            SearchViewModel(moviesRepository)
    }

    @Test
    fun getSearchedMovies() {
        val movieSearchQuery = "taken"
        val dummyMovieSearchResult = DataDummy.generateRemoteDummyMovies()
        val movieSearchResult = MutableLiveData<MutableList<MovieData>>()
        movieSearchResult.value = dummyMovieSearchResult

        Mockito.`when`(moviesRepository.searchMovies(movieSearchQuery))
            .thenReturn(movieSearchResult)
        val searchedMoviesResult = searchViewModel.getSearchedMovies(movieSearchQuery)?.value

        Mockito.verify(moviesRepository).searchMovies(movieSearchQuery)
        assertNotNull(searchedMoviesResult)
        assertEquals(dummyMovieSearchResult.size, searchedMoviesResult?.size)

    }

    @Test
    fun getSearchedTVShows() {
        val tvShowSearchQuery = "winter"
        val dummyTVShowSearchResult = DataDummy.generateRemoteDummyTVShow()
        val tvShowSearchResult = MutableLiveData<MutableList<TVShowData>>()
        tvShowSearchResult.value = dummyTVShowSearchResult

        Mockito.`when`(moviesRepository.searchTVShows(tvShowSearchQuery))
            .thenReturn(tvShowSearchResult)
        val searchedTVShowResult = searchViewModel.getSearchedTVShows(tvShowSearchQuery)?.value

        Mockito.verify(moviesRepository).searchTVShows(tvShowSearchQuery)
        assertNotNull(searchedTVShowResult)
        assertEquals(dummyTVShowSearchResult.size, searchedTVShowResult?.size)

    }
}