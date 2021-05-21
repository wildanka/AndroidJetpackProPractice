package com.wildanka.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import com.wildanka.moviecatalogue.data.datasource.remote.RemoteDataSource
import com.wildanka.moviecatalogue.util.DataDummy
import com.wildanka.moviecatalogue.util.LiveDataTestUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val fakeMovieRepository = FakeMovieRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].idMovie
    private val tvShowResponses = DataDummy.generateRemoteDummyTVShow()
    private val tvShowId = tvShowResponses[0].idTVShow

    private val detailMovie = DataDummy.generateRemoteDummyMovieDetail(movieId)

    @Test
    fun getAllMovies(){
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadMoviesCallback).onAllMovieReceived(movieResponses)
        }.`when`(remote).fetchMovieData(any())
        val movies = LiveDataTestUtil.getValue(fakeMovieRepository.fetchMovieData())
        verify(remote).fetchMovieData(any())
        assertNotNull(movies)
        assertEquals(movies.size.toLong(), movieResponses.size.toLong())

    }

    fun getAllTVShow(){

    }
}