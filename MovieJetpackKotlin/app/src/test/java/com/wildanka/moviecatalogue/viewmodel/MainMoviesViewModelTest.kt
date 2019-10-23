package com.wildanka.moviecatalogue.viewmodel

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.entity.Movie
import com.wildanka.moviecatalogue.entity.TvShow
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
        val expectedSize = 0
        Assert.assertTrue("asa", mainViewModel.getMovieList().size > expectedSize)
    }

    @Test
    fun getTVShowList() {
        val expectedSize = 0
        Assert.assertTrue("asa", mainViewModel.getTVShowList().size > expectedSize)
    }
}