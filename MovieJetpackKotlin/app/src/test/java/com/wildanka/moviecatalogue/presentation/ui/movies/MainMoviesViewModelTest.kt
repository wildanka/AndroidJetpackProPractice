package com.wildanka.moviecatalogue.presentation.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.wildanka.moviecatalogue.data.MoviesRepository
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*

class MainMoviesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainViewModel: MainMoviesViewModel

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setUp() {
        moviesRepository = Mockito.mock(MoviesRepository::class.java)
        mainViewModel =
            MainMoviesViewModel()
    }

    @Test
    fun getMovieListRemote() {
        val mainViewModel = mock(MainMoviesViewModel::class.java)
        val dummyMovie = MovieData(
            "475557",
            5589,
            "Joker",
            "2019-10-02",
            8.4,
            "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
            "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
            "en",
            "422.288",
            false
        )
        val movieDummyLiveData: MutableLiveData<MutableList<MovieData>> =
            MutableLiveData() //construct dummyMutableLiveData

        //buat data list dummy
        val dummyMovieList: MutableList<MovieData> = mutableListOf()
        for (i in 0..15) dummyMovieList.add(dummyMovie)
        movieDummyLiveData.value = dummyMovieList

        `when`(mainViewModel.getMovieList()).thenReturn(movieDummyLiveData)

        //verify onChanged pada livedata
        val observer: Observer<MutableList<MovieData>> = mock(Observer::class.java) as Observer<MutableList<MovieData>>
        mainViewModel.getMovieList()?.observeForever(observer)
        verify(observer).onChanged(dummyMovieList)
    }

    @Test
    fun getTVShowListRemote() {
        val mainViewModel = mock(MainMoviesViewModel::class.java)
        val dummyTVShow = TVShowData(
            "71712",
            432,
            "The Good Doctor",
            "The Good Doctor",
            "2017-09-25",
            7.7,
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
            "/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg",
            "en",
            "80.784"
        )
        val tvShowDummyLiveData: MutableLiveData<MutableList<TVShowData>> =
            MutableLiveData() //construct dummyMutableLiveData

        //buat data list dummy
        val dummyTVShowList: MutableList<TVShowData> = mutableListOf()
        for (i in 0..15) dummyTVShowList.add(dummyTVShow)
        tvShowDummyLiveData.value = dummyTVShowList

        //return dummy data
        `when`(mainViewModel.getTVShowList()).thenReturn(tvShowDummyLiveData)

        //verify onChanged pada livedata
        val observer: Observer<MutableList<TVShowData>> = mock(Observer::class.java) as Observer<MutableList<TVShowData>>
        mainViewModel.getTVShowList()?.observeForever(observer)
        verify(observer).onChanged(dummyTVShowList)
    }
    @Test
    fun getMovieListLocal() {
        val mainViewModel = mock(MainMoviesViewModel::class.java)
        val dummyMovie = MovieData(
            "475557",
            5589,
            "Joker",
            "2019-10-02",
            8.4,
            "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
            "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
            "en",
            "422.288",
            false
        )
        val movieDummyLiveData: MutableLiveData<MutableList<MovieData>> =
            MutableLiveData() //construct dummyMutableLiveData

        //buat data list dummy
        val dummyMovieList: MutableList<MovieData> = mutableListOf()
        for (i in 0..15) dummyMovieList.add(dummyMovie)
        movieDummyLiveData.value = dummyMovieList

        `when`(mainViewModel.getMovieList()).thenReturn(movieDummyLiveData)

        //verify onChanged pada livedata
        val observer: Observer<MutableList<MovieData>> = mock(Observer::class.java) as Observer<MutableList<MovieData>>
        mainViewModel.getMovieList()?.observeForever(observer)
        verify(observer).onChanged(dummyMovieList)
    }

    @Test
    fun getTVShowListLocal() {
        val mainViewModel = mock(MainMoviesViewModel::class.java)
        val dummyTVShow = TVShowData(
            "71712",
            432,
            "The Good Doctor",
            "The Good Doctor",
            "2017-09-25",
            7.7,
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
            "/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg",
            "en",
            "80.784"
        )
        val tvShowDummyLiveData: MutableLiveData<MutableList<TVShowData>> =
            MutableLiveData() //construct dummyMutableLiveData

        //buat data list dummy
        val dummyTVShowList: MutableList<TVShowData> = mutableListOf()
        for (i in 0..15) dummyTVShowList.add(dummyTVShow)
        tvShowDummyLiveData.value = dummyTVShowList

        //return dummy data
        `when`(mainViewModel.getTVShowList()).thenReturn(tvShowDummyLiveData)

        //verify onChanged pada livedata
        val observer: Observer<MutableList<TVShowData>> = mock(Observer::class.java) as Observer<MutableList<TVShowData>>
        mainViewModel.getTVShowList()?.observeForever(observer)
        verify(observer).onChanged(dummyTVShowList)
    }
}