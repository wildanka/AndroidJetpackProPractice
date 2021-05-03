package com.wildanka.moviecatalogue

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import com.wildanka.moviecatalogue.remote.view.adapter.MovieRVAdapter
import com.wildanka.moviecatalogue.remote.view.adapter.TVShowRVAdapter
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

const val core_testing = "androidx.arch.core:core-testing:2.1.0"

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun testViewTvShows(){
        //Scenario: Lihat Next swipe left pada viewpager untuk melihat tv show
        onView(withId(R.id.vp_movie)).perform(swipeLeft())
    }

    @Test
    fun testViewMovies(){
        //tekan tab "MOVIE" pada tab layout setelah melakukan swipe ke kiri (dari tab TV Show)
        onView(withId(R.id.vp_movie)).perform(swipeLeft())
        val matcher = allOf(
            withText("MOVIE"),
            isDescendantOfA(withId(R.id.tl_menu))
        )
        onView(matcher).perform(click())
    }

    @Test
    fun testMovieRecyclerBehavior() {
        //buat dummy data objek movie
        // Lakukan klik pada item di posisi ke 0 - Joker
        onView(allOf(isDisplayed(), withId(R.id.rv_movie)))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MovieRVAdapter.MovieViewHolder>(0, click()))

        val titleMatcher= withId(R.id.tv_title)
        onView(withId(R.id.tv_title)).check(matches(titleMatcher))
    }

    @Test
    fun testTVShowRecyclerBehavior() {
        // Lakukan klik pada item di posisi ke 4 (indeks dimulai dari 0) - The Flash
        val matcher = allOf(
            withText("TV SHOW"),
            isDescendantOfA(withId(R.id.tl_menu))
        )
        onView(matcher).perform(click())
        onView(allOf(isDisplayed(), withId(R.id.rv_movie)))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TVShowRVAdapter.TVShowViewHolder>(4, click()))

        val titleMatcher= withId(R.id.tv_title)
        onView(withId(R.id.tv_title)).check(matches(titleMatcher))
    }

}
