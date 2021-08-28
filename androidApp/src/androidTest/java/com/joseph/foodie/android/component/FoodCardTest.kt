package com.joseph.foodie.android.component

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import org.junit.Test

class FoodCardTest  {

    @Test
    fun testFoodCard (){
        var ctx: Context = ApplicationProvider.getApplicationContext()
        var view = FoodCard(ctx)
        /*
     * Measure and layout the view. In this example we give an exact
     * width but all the height to be WRAP_CONTENT.
     */
        ViewHelpers.setupView(view)
            .setExactWidthDp(150)
            .setExactHeightDp(200)
            .layout();

        /*
         * Take the actual screenshot. At the end of this call the screenshot
         * is stored on the device, and the gradle plugin takes care of
         * pulling it and displaying it to you in nice ways.
         */
        Screenshot.snap(view)
            .setName("FoodCard")
            .record();
    }
}