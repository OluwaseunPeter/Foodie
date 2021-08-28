package com.joseph.foodie.android.component

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import com.facebook.testing.screenshot.ScreenshotRunner

class FoodieTestRunner : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        ScreenshotRunner.onCreate(this, arguments);
        super.onCreate(arguments)
    }

    override fun finish(resultCode: Int, results: Bundle?) {
        ScreenshotRunner.onDestroy();
        super.finish(resultCode, results)
    }
}