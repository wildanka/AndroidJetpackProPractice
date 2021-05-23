package com.wildanka.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.wildanka.moviecatalogue.data.datasource.remote.RemoteDataSource
import com.wildanka.moviecatalogue.util.DataDummy
import com.wildanka.moviecatalogue.util.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val fakeMovieRepository = FakeMovieRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = "460465"
    private val tvShowResponses = DataDummy.generateRemoteDummyTVShow()
    private val tvShowId = "88396"
    private val movieSearchQuery = "taken"
    private val tvShowSearchQuery = "winter"

    private val detailMovie = DataDummy.generateRemoteDummyMovieDetail(movieId)
    private val detailTVShow = DataDummy.generateRemoteDummyTVShowDetail(tvShowId)
    private val movieCredits = DataDummy.generateRemoteDummyMovieCredits(movieId)
    private val tvShowCredits = DataDummy.generateRemoteDummyTVShowCredits(tvShowId)

    @Test
    fun getAllMovies() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadMoviesCallback).onAllMovieReceived(
                movieResponses
            )
        }.`when`(remote).fetchMovieData(any())
        val movies = LiveDataTestUtil.getValue(fakeMovieRepository.fetchMovieData())
        verify(remote).fetchMovieData(any())
        assertNotNull(movies)
        assertEquals(movies.size.toLong(), movieResponses.size.toLong())

    }

    @Test
    fun getAllTVShow() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadTVShowsCallback).onAllTVShowReceived(
                tvShowResponses
            )
        }.`when`(remote).fetchTVShowData(any())
        val tvShowData = LiveDataTestUtil.getValue(fakeMovieRepository.fetchTVShowData())
        verify(remote).fetchTVShowData(any())
        assertNotNull(tvShowData)
        assertEquals(tvShowData.size.toLong(), tvShowResponses.size.toLong())
    }

    @Test
    fun testFetchMovieDataDetail() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[1] as RemoteDataSource.LoadMovieDetailCallback).onMovieDetailReceived(
                detailMovie
            )
            null
        }.`when`(remote).fetchMovieDataDetail(eq(movieId), any())

        val movieDetail =
            LiveDataTestUtil.getValue(fakeMovieRepository.fetchMovieDataDetail(movieId))

        verify(remote).fetchMovieDataDetail(eq(movieId), any())

        assertNotNull(movieDetail)
        assertEquals(movieDetail, detailMovie)
    }

    @Test
    fun testFetchTvShowDataDetail() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[1] as RemoteDataSource.LoadTVShowDetailCallback).onTVShowDetailReceived(
                detailTVShow
            )
            null
        }.`when`(remote).fetchTvShowDataDetail(eq(tvShowId), any())
        val tvShowData =
            LiveDataTestUtil.getValue(fakeMovieRepository.fetchTvShowDataDetail(tvShowId))
        verify(remote).fetchTvShowDataDetail(eq(tvShowId), any())
        assertNotNull(tvShowData)
        assertEquals(tvShowData, detailTVShow)
    }

    @Test
    fun testMovieDetailCredits() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[1] as RemoteDataSource.LoadMovieDetailCreditCallback).onMovieDetailCreditReceived(
                movieCredits
            )
            null
        }.`when`(remote).fetchMovieDetailCredits(eq(tvShowId), any())
        val movieCreditsResponse =
            LiveDataTestUtil.getValue(fakeMovieRepository.fetchMovieDetailCredits(tvShowId))
        verify(remote).fetchMovieDetailCredits(eq(tvShowId), any())
        assertNotNull(movieCreditsResponse)
        assertEquals(movieCreditsResponse, movieCredits)
    }

    @Test
    fun testTVShowDetailCredits() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[1] as RemoteDataSource.LoadTVShowDetailCreditCallback).onTVShowDetailCreditReceived(
                tvShowCredits
            )
            null
        }.`when`(remote).fetchTVShowDetailCredits(eq(tvShowId), any())
        val tvShowCreditsResponse =
            LiveDataTestUtil.getValue(fakeMovieRepository.fetchTVShowDetailCredits(tvShowId))
        verify(remote).fetchTVShowDetailCredits(eq(tvShowId), any())
        assertNotNull(tvShowCreditsResponse)
        assertEquals(tvShowCreditsResponse, tvShowCredits)
    }


    @Test
    fun searchMovies() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[1] as RemoteDataSource.LoadMovieSearchCallback).onMovieFound(
                movieResponses
            )
            null
        }.`when`(remote).searchMovies(eq(movieSearchQuery), any())
        val movies = LiveDataTestUtil.getValue(fakeMovieRepository.searchMovies(movieSearchQuery))
        verify(remote).searchMovies(eq(movieSearchQuery), any())
        assertNotNull(movies)
        assertEquals(movies.size.toLong(), movieResponses.size.toLong())
    }

    @Test
    fun searchTVShow() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[1] as RemoteDataSource.LoadTVShowSearchCallback).onTVShowFound(
                tvShowResponses
            )
            null
        }.`when`(remote).searchTVShows(eq(tvShowSearchQuery), any())
        val tvShowData =
            LiveDataTestUtil.getValue(fakeMovieRepository.searchTVShows(tvShowSearchQuery))
        verify(remote).searchTVShows(eq(tvShowSearchQuery), any())
        assertNotNull(tvShowData)
        assertEquals(tvShowData.size.toLong(), tvShowResponses.size.toLong())
    }

}