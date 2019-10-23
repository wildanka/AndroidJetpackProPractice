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


class MoviesDetailViewModelTest {
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
        val movieIndex = 0
        val expected = Movie(
            "A Star Is Born",
            "October 5, 2018",
            "75",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just\n" +
                    "            about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…\n" +
                    "        ",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just\n" +
                    "            about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even\n" +
                    "            as Ally\\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an\n" +
                    "            ongoing battle with his own internal demons.\n" +
                    "        ",
            com.wildanka.moviecatalogue.R.drawable.poster_a_start_is_born
        )
        moviesDetailViewModel.getMoviesAtIndex(movieIndex)
        Assert.assertEquals(expected, moviesDetailViewModel.getMoviesAtIndex(movieIndex))
    }

    @Test
    fun getTVShowAtIndex() {
        // tes ketika meload detail dari TV Show dari Viewmodel,
        // ketika user memilih data ke-0 maka result seharusnya adalah acara TV berjudul "Arrow"
        val tvShowIndex = 0
        val expected = TvShow(
            "Arrow",
            "October 10, 2012",
            "75",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He\n" +
                    "            returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a…\n" +
                    "        ",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He\n" +
                    "            returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a\n" +
                    "            bow",
            com.wildanka.moviecatalogue.R.drawable.poster_arrow
        )
        moviesDetailViewModel.getTVShowAtIndex(tvShowIndex)
        Assert.assertEquals(expected, moviesDetailViewModel.getTVShowAtIndex(tvShowIndex))
    }
}