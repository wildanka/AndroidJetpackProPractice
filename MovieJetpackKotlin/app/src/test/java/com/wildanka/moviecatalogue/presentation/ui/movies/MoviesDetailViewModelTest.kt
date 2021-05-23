package com.wildanka.moviecatalogue.presentation.ui.movies


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowDetail
import com.wildanka.moviecatalogue.domain.entity.MovieCredits
import com.wildanka.moviecatalogue.domain.entity.MovieDetail
import com.wildanka.moviecatalogue.util.DataDummy
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify


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
        moviesDetailViewModel =
            MoviesDetailViewModel(moviesRepository)
    }

    @Test
    fun getMoviesDetailWithID() {
        // tes ketika meload detail dari Movie dari Viewmodel,
        // ketika user memilih data dengan movie ID = 475557 maka result seharusnya adalah film berjudul "Joker"
        val dummyMovieId = "475557"
        val dummyMovie = DataDummy.generateRemoteDummyMovieDetail(dummyMovieId)
        val movie = MutableLiveData<MovieDetail>()
        movie.value = dummyMovie

        `when`(moviesRepository.fetchMovieDataDetail(dummyMovieId)).thenReturn(movie)
        val tvShowResponse = moviesDetailViewModel.getMoviesDetailWithID(dummyMovieId)?.value

        verify(moviesRepository).fetchMovieDataDetail(dummyMovieId)
        Assert.assertNotNull(tvShowResponse)
        assertEquals(dummyMovie.title, tvShowResponse?.title)
    }

    @Test
    fun getMoviesCastData() {
        // tes ketika meload cast Movie dari Viewmodel,
        // ketika user memilih data movie dengan ID 475557
        // maka result seharusnya adalah aktor bernama "Joaquin Phoenix" dengan character "Arthur Fleck / Joker"

        val dummyMovieId = "460465"
        val dummyMovieCast = DataDummy.generateRemoteDummyMovieCredits(dummyMovieId)
        val movieCredits = MutableLiveData<MovieCredits>()
        movieCredits.value = dummyMovieCast

        `when`(moviesRepository.fetchTVShowDetailCredits(dummyMovieId)).thenReturn(movieCredits)
        val movieCreditResponse = moviesDetailViewModel.getTVShowCastData(dummyMovieId)?.value

        verify(moviesRepository).fetchTVShowDetailCredits(dummyMovieId)
        Assert.assertNotNull(movieCreditResponse)
        assertEquals(dummyMovieCast.cast.size, movieCreditResponse?.cast?.size)
        assertEquals(dummyMovieCast.cast[0].character, movieCreditResponse?.cast?.get(0)?.character)
        assertEquals(dummyMovieCast.cast[0].name, movieCreditResponse?.cast?.get(0)?.name)
        assertEquals(dummyMovieCast.cast[0].profilePath, movieCreditResponse?.cast?.get(0)?.profilePath)
    }

    @Test
    fun getTVShowDetailWithID() {
        // tes ketika meload detail dari TV Show dari Viewmodel,
        // ketika user memilih data TVShow dengan ID = 71712,
        // maka result seharusnya adalah acara TV berjudul "The Good Doctor"
        val dummyTVShowId = "88396"
        val dummyTvShow = DataDummy.generateRemoteDummyTVShowDetail(dummyTVShowId)
        val tvShow = MutableLiveData<TVShowDetail>()
        tvShow.value = dummyTvShow

        `when`(moviesRepository.fetchTvShowDataDetail(dummyTVShowId)).thenReturn(tvShow)
        val tvShowResponse = moviesDetailViewModel.getTVShowDetailWithId(dummyTVShowId)?.value

        verify(moviesRepository).fetchTvShowDataDetail(dummyTVShowId)
        Assert.assertNotNull(tvShowResponse)
        assertEquals(dummyTvShow.title, tvShowResponse?.title)
    }

    @Test
    fun getTVShowCastData() {
        // tes ketika meload cast Movie dari Viewmodel,
        // ketika user memilih data movie dengan ID 71712
        // maka result seharusnya adalah aktor bernama "Freddie Highmore" dengan character "Shaun Murphy"


        val dummyTVShowId = "88396"
        val dummyTVShowCast = DataDummy.generateRemoteDummyTVShowCredits(dummyTVShowId)
        val tvShowCredits = MutableLiveData<MovieCredits>()
        tvShowCredits.value = dummyTVShowCast

        `when`(moviesRepository.fetchTVShowDetailCredits(dummyTVShowId)).thenReturn(tvShowCredits)
        val tvShowCreditsResponse = moviesDetailViewModel.getTVShowCastData(dummyTVShowId)?.value

        verify(moviesRepository).fetchTVShowDetailCredits(dummyTVShowId)
        Assert.assertNotNull(tvShowCreditsResponse)
        assertEquals(dummyTVShowCast.cast.size, tvShowCreditsResponse?.cast?.size)
        assertEquals(dummyTVShowCast.cast[0].character, tvShowCreditsResponse?.cast?.get(0)?.character)
        assertEquals(dummyTVShowCast.cast[0].name, tvShowCreditsResponse?.cast?.get(0)?.name)
        assertEquals(dummyTVShowCast.cast[0].profilePath, tvShowCreditsResponse?.cast?.get(0)?.profilePath)
    }

}