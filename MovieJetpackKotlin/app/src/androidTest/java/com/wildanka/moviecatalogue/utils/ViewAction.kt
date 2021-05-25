package com.wildanka.moviecatalogue.utils

import android.view.View
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import org.hamcrest.Matcher


/**
 * Perform action of waiting for a specific time. (this is for delaying specific animation, which is working synchronously on UI Thread, so to add delay into the process, we use this class
 */
fun waitFor(millis: Long): ViewAction {
    return object : ViewAction {

        override fun getConstraints(): Matcher<View> {
            return isRoot()
        }

        override fun getDescription(): String {
            return "Wait for $millis milliseconds."
        }

        override fun perform(uiController: androidx.test.espresso.UiController?, view: View?) {
            uiController?.loopMainThreadForAtLeast(millis)
        }
    }
}
