plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services") // Add this line to apply the Google Services plugin
}

android {
    namespace = "com.example.firebasedemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.firebasedemo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    // Use Firebase BOM to manage versions
    implementation(platform("com.google.firebase:firebase-bom:32.2.0")) // Use the latest BOM version
    implementation("com.google.firebase:firebase-database-ktx") // KTX version of Firebase Database
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation(libs.firebase.database) // KTX version of Firebase Auth
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.google.firebase:firebase-database:21.0.0")
}
