// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    // Uncomment when ready to add Firebase
    // id("com.google.gms.google-services")
    //id("kotlin-parcelize")
    //id("kotlin-kapt")
    // Uncomment when using Hilt
    // id("dagger.hilt.android.plugin")
}