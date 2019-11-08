package com.wildanka.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.wildanka.moviecatalogue.MoviesRepository
import com.wildanka.moviecatalogue.model.entity.*
import com.wildanka.moviecatalogue.util.getOrAwaitValue
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import java.math.BigInteger


class MoviesDetailViewModelTest {
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesDetailViewModel: MoviesDetailViewModel

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setUp() {
        moviesRepository = Mockito.mock(MoviesRepository::class.java)
        moviesDetailViewModel = MoviesDetailViewModel()
    }

    @Test
    fun getMoviesAtIndex() {
        // tes ketika meload detail dari Movie dari Viewmodel,
        // ketika user memilih data ke-0 maka result seharusnya adalah film berjudul "A Star Is Born"
        val movieIndex = "475557"
        val expectedTitle = "Joker"
        moviesDetailViewModel.getMoviesDetailWithID(movieIndex)
        Assert.assertEquals(
            expectedTitle,
            moviesDetailViewModel.getMoviesDetailWithID(movieIndex)?.getOrAwaitValue()?.title
        )
    }

    @Test
    fun getTVShowAtIndex() {
        // tes ketika meload detail dari TV Show dari Viewmodel,
        // ketika user memilih data ke-0 maka result seharusnya adalah acara TV berjudul "Arrow"
        val movieIndex = "71712"
        val expectedName = "The Good Doctor"
        moviesDetailViewModel.getTVShowDetailWithId(movieIndex)
        Assert.assertEquals(
            expectedName,
            moviesDetailViewModel.getTVShowDetailWithId(movieIndex)?.getOrAwaitValue()?.title
        )
    }
}