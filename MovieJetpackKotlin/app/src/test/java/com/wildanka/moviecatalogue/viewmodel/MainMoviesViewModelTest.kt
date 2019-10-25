package com.wildanka.moviecatalogue.viewmodel

import com.wildanka.moviecatalogue.MoviesRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class MainMoviesViewModelTest {
    @Mock
    private lateinit var mainViewModel: MainMoviesViewModel

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setUp() {
        moviesRepository = Mockito.mock(MoviesRepository::class.java)
        mainViewModel = MainMoviesViewModel()
    }

    @Test
    fun getMovieList() {
        //test mainViewModel.getMovieList is it return movie list (more than 10)
        val expectedSize = 10
        Assert.assertTrue("MovieList Data", mainViewModel.getMovieList()?.size ?: 0 > expectedSize)
    }

    @Test
    fun getTVShowList() {
        //test mainViewModel.getTVShowList is it return tv show list (more than 10)
        val expectedSize = 10
        Assert.assertTrue("TVShowList Data", mainViewModel.getTVShowList()?.size ?: 0 > expectedSize)
    }
}