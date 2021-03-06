package com.example.Yizazun

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class SpecialOfferDetailNavigationTest{
    @Test
    fun click_editButton_navigateTo_editFragment() {
        val scenario = launchFragmentInContainer<SpecialOfferDetailFragment>(Bundle(), R.style.AppTheme)
        val navController = Mockito.mock(NavController::class.java)

        scenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }


        Espresso.onView(ViewMatchers.withId(R.id.edit_btn)).perform(ViewActions.click())

        Mockito.verify(navController).navigate(
            SpecialOfferDetailFragmentDirections.action_specialOfferDetailFragment_to_editSpecialOfferFragment())
    }
}