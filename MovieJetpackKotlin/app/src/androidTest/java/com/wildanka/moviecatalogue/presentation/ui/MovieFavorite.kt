package com.wildanka.moviecatalogue.presentation.ui


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.utils.waitFor
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MovieFavorite {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addMovieToFavoriteAndDisplayIt() {
        val recyclerView = onView(
            allOf(
                withId(R.id.rv_movie),
                isDisplayed()
            )
        )
        onView(isRoot()).perform(waitFor(5000))
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(1, click()))

        val actionMenuItemView = onView(
            allOf(
                withId(R.id.favorites_toggle), withContentDescription("Add to Favorites"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.action_bar),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView.perform(click())

        pressBack()

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.favoritesFragment), withContentDescription("Favorites"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_view),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val recyclerView2 = onView(
            allOf(
                withId(R.id.rv_movie),
                isDisplayed()
            )
        )
        onView(isRoot()).perform(waitFor(5000))
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(0, click()))
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
}
