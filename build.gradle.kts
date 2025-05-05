// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("org.jetbrains.compose") version "1.5.11" apply false
    // Uncomment when ready to add Firebase
    // id("com.google.gms.google-services")
    //id("kotlin-parcelize")
    //id("kotlin-kapt")
    // Uncomment when using Hilt
    id("com.google.dagger.hilt.android") version "2.50" apply false
}