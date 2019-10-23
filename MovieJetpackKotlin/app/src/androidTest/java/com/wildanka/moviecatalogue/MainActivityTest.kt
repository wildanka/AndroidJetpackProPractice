package com.wildanka.moviecatalogue

import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.wildanka.moviecatalogue.view.adapter.MovieRVAdapter
import com.wildanka.moviecatalogue.view.adapter.TVShowRVAdapter
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewTvShows(){
        //TODO : Lihat Next Match
        onView(withId(R.id.vp_movie)).perform(swipeLeft())
    }

    @Test
    fun testViewMovies(){
        val matcher = allOf(
            withText("MOVIE"),
            isDescendantOfA(withId(R.id.tl_menu))
        )
        onView(matcher).perform(click())
        SystemClock.sleep(800) // Wait a little until the content is loaded
    }

    @Test
    fun testMovieRecyclerBehavior() {
        onView(allOf(isDisplayed(), withId(R.id.rv_movie)))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MovieRVAdapter.MovieViewHolder>(2, click()))
        SystemClock.sleep(1600) // Wait a little until the content is loaded

//        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
//        onView(withId(R.id.rv_movie)).perform(
//            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click())
//        )
    }

    @Test
    fun testTVShowRecyclerBehavior() {
        val matcher = allOf(
            withText("TV SHOW"),
            isDescendantOfA(withId(R.id.tl_menu))
        )
        onView(matcher).perform(click())
        onView(allOf(isDisplayed(), withId(R.id.rv_movie)))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TVShowRVAdapter.TVShowViewHolder>(2, click()))
        SystemClock.sleep(1600) // Wait a little until the content is loaded

//        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
//        onView(withId(R.id.rv_movie)).perform(
//            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click())
//        )
    }

/*    @Test
    fun mainActivityTest() {

    }*/
}
