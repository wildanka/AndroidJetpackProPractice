package com.wildanka.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.wildanka.moviecatalogue.remote.viewmodel.MoviesDetailViewModel
import com.wildanka.moviecatalogue.remote.repository.MoviesRepository
import com.wildanka.moviecatalogue.util.getOrAwaitValue
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


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
    fun getMoviesDetailWithID() {
        // tes ketika meload detail dari Movie dari Viewmodel,
        // ketika user memilih data dengan movie ID = 475557 maka result seharusnya adalah film berjudul "Joker"
        val movieIndex = "475557"
        val expectedTitle = "Joker"
        moviesDetailViewModel.getMoviesDetailWithID(movieIndex)
        Assert.assertEquals(
            expectedTitle,
            moviesDetailViewModel.getMoviesDetailWithID(movieIndex)?.getOrAwaitValue()?.title
        )
    }

    @Test
    fun getMoviesCastData() {
        // tes ketika meload cast Movie dari Viewmodel,
        // ketika user memilih data movie dengan ID 475557
        // maka result seharusnya adalah aktor bernama "Joaquin Phoenix" dengan character "Arthur Fleck / Joker"
        val movieIndex = "475557"
        val expectedActor = "Joaquin Phoenix"
        val expectedCharacter = "Arthur Fleck / Joker"
        moviesDetailViewModel.getMoviesCastData(movieIndex)
        Assert.assertEquals(
            expectedActor,
            moviesDetailViewModel.getMoviesCastData(movieIndex)?.getOrAwaitValue()?.cast?.get(0)?.name
        )
        Assert.assertEquals(
            expectedCharacter,
            moviesDetailViewModel.getMoviesCastData(movieIndex)?.getOrAwaitValue()?.cast?.get(0)?.character
        )
    }

    @Test
    fun getTVShowDetailWithID() {
        // tes ketika meload detail dari TV Show dari Viewmodel,
        // ketika user memilih data TVShow dengan ID = 71712,
        // maka result seharusnya adalah acara TV berjudul "The Good Doctor"
        val movieIndex = "71712"
        val expectedName = "The Good Doctor"
        moviesDetailViewModel.getTVShowDetailWithId(movieIndex)
        Assert.assertEquals(
            expectedName,
            moviesDetailViewModel.getTVShowDetailWithId(movieIndex)?.getOrAwaitValue()?.title
        )
    }

    @Test
    fun getTVShowCastData() {
        // tes ketika meload cast Movie dari Viewmodel,
        // ketika user memilih data movie dengan ID 71712
        // maka result seharusnya adalah aktor bernama "Freddie Highmore" dengan character "Shaun Murphy"
        val movieIndex = "71712"
        val expectedActor = "Freddie Highmore"
        val expectedCharacter = "Shaun Murphy"
        Assert.assertEquals(
            expectedActor,
            moviesDetailViewModel.getTVShowCastData(movieIndex)?.getOrAwaitValue()?.cast?.get(0)?.name
        )
        Assert.assertEquals(
            expectedCharacter,
            moviesDetailViewModel.getTVShowCastData(movieIndex)?.getOrAwaitValue()?.cast?.get(0)?.character
        )
    }

}