plugins {
    id("com.android.application")
    kotlin("android")
    id("com.facebook.testing.screenshot")
    id("kotlin-android")

}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    //Animation
    implementation("androidx.dynamicanimation:dynamicanimation:")

    //Facebook screenshot Test
    // Standard Android View Plugins (TextView, etc)
    implementation("com.facebook.testing.screenshot:layout-hierarchy-common:0.14.0")
    // Litho Component Plugins
    implementation("com.facebook.testing.screenshot:layout-hierarchy-litho:0.14.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    //Testing framework
    androidTestImplementation("androidx.test:runner:1.1.1")
    testImplementation("junit:junit:4.13.1")

    androidTestImplementation("androidx.test:core:1.1.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")

    testImplementation( "androidx.test:core-ktx:1.3.0")
    testImplementation( "androidx.test.ext:junit-ktx:1.1.2")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.joseph.foodie.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner("com.joseph.foodie.android.component.FoodieTestRunner")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    testOptions {
        unitTests.isIncludeAndroidResources =  true
    }

    screenshots{
        referenceDir = "$projectDir/screenshots/"
    }

    buildFeatures {
        viewBinding = true
    }
}