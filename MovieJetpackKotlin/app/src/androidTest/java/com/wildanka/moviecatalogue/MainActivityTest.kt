package com.wildanka.moviecatalogue

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.wildanka.moviecatalogue.presentation.ui.MainActivity
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.MovieRVAdapter
import com.wildanka.moviecatalogue.presentation.ui.movies.adapter.TVShowRVAdapter
import com.wildanka.moviecatalogue.util.EspressoIdlingResource
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
//        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun testViewTvShows() {
        //Scenario: tekan bottomNavigation pada menu "TV Show" untuk melihat daftar tv show dari API
        onView(withId(R.id.tvShowFragment)).perform(click())
    }

    @Test
    fun testViewMovies() {
        //Scenario: tekan bottomNavigation pada menu "Movie" untuk melihat daftar movie dari API
        onView(withId(R.id.movieFragment)).perform(click())
    }

    @Test
    fun testViewFavoriteMovie() {
        //Scenario: tekan bottomNavigation pada menu "Favorites" untuk melihat daftar favorite movie yang telah disimpan oleh user
        onView(withId(R.id.favoritesFragment)).perform(click())
    }

    @Test
    fun testViewFavoriteTVShow() {
        //Scenario: tekan bottomNavigation pada menu "Favorites" untuk melihat daftar favorite tv show yang telah disimpan oleh user
        onView(withId(R.id.favoritesFragment)).perform(click())
        onView(withId(R.id.vp_movie)).perform(swipeLeft())
        onView(withId(R.id.vp_movie)).perform(swipeRight())
        val matcherMovies = allOf(
            withText("MOVIES"),
            isDescendantOfA(withId(R.id.tl_menu))
        )
        onView(matcherMovies).perform(click())

        //tekan tab "TV SHOWS" pada tab layout setelah melakukan swipe ke kiri (dari tab MOVIES)
        val matcher = allOf(
            withText("TV SHOWS"),
            isDescendantOfA(withId(R.id.tl_menu))
        )
        onView(matcher).perform(click())
    }

    @Test
    fun testShowFavoriteMovieDetail() {
        //1. open the movie detail
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        //2. save to favorite
        val btnFavorite = withId(R.id.favorites_toggle)
        onView(btnFavorite).perform(click())
        val favoritedButton = onView(
            allOf(
                withId(R.id.favorites_toggle), withContentDescription("Add to Favorites"),
                withParent(withParent(withId(R.id.action_bar))),
                isDisplayed()
            )
        )
        favoritedButton.check(matches(isDisplayed()))

        //back
        onView(isRoot()).perform(pressBack())

        //go to favorites menu
        onView(withId(R.id.favoritesFragment)).perform(click())
        onView(withId(R.id.vp_movie)).perform(swipeRight())

        onView(nthChildOf(withId(R.id.vp_movie), 0)).check(matches(withText("MOVIES"))).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )


//        onView(withId(R.id.rv_movie)).perform(
//            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
//                0,
//                click()
//            )
//        )

    }

    @Test
    fun testTVShowRecyclerBehavior() {
        // Lakukan klik pada item di posisi ke 4, masuk ke halaman detail, pastikan judulnya sesuai
        onView(withId(R.id.tvShowFragment)).perform(click())
        onView(allOf(isDisplayed(), withId(R.id.rv_movie)))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<TVShowRVAdapter.TVShowViewHolder>(
                    4,
                    click()
                )
            )

        val titleMatcher = withId(R.id.tv_title)
        onView(withId(R.id.tv_title)).check(matches(titleMatcher))
    }

    @Test
    fun testAddMovieToFavorite() {
        /**
         * 1. masuk ke menu movie
         * 2. klik pada item movie ke 4
         * 3. menambahkan data movie ke favorite movie
         */
        onView(withId(R.id.movieFragment)).perform(click())
        onView(allOf(isDisplayed(), withId(R.id.rv_movie)))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<MovieRVAdapter.MovieViewHolder>(
                    4,
                    click()
                )
            )

        val btnFavorite = withId(R.id.favorites_toggle)
        onView(btnFavorite).perform(click())

        val favoritedButton = onView(
            allOf(
                withId(R.id.favorites_toggle), withContentDescription("Add to Favorites"),
                withParent(withParent(withId(R.id.action_bar))),
                isDisplayed()
            )
        )

        favoritedButton.check(matches(isDisplayed()))
    }

    @Test
    fun testAddTVShowToFavorite() {
        // Menambahkan data tv show ke dalam favorite
        onView(withId(R.id.tvShowFragment)).perform(click())
        onView(allOf(isDisplayed(), withId(R.id.rv_movie)))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<TVShowRVAdapter.TVShowViewHolder>(
                    4,
                    click()
                )
            )

        val btnFavorite = withId(R.id.favorites_toggle)
        onView(btnFavorite).perform(click())

        val favoritedButton = onView(
            allOf(
                withId(R.id.favorites_toggle), withContentDescription("Add to Favorites"),
                withParent(withParent(withId(R.id.action_bar))),
                isDisplayed()
            )
        )

        favoritedButton.check(matches(isDisplayed()))
    }


    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

    fun nthChildOf(parentMatcher: Matcher<View?>, childPosition: Int): Matcher<View?>? {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("with $childPosition child view of type parentMatcher")
            }

            override fun matchesSafely(view: View): Boolean {
                if (view.parent !is ViewGroup) {
                    return parentMatcher.matches(view.parent)
                }
                val group = view.parent as ViewGroup
                return parentMatcher.matches(view.parent) && group.getChildAt(childPosition) == view
            }
        }
    }

}
