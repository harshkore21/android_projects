// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.google.gms.google.services) apply false
}

buildscript {
    repositories {
        google() // Ensure to include the Google repository
        mavenCentral() // Include Maven Central for other dependencies
    }
    dependencies {
//        classpath("com.google.gms:google-services:4.3.14") // Ensure correct syntax
        classpath ("com.google.gms:google-services:4.4.2")
    }
}
