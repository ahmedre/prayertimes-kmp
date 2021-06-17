plugins {
    id("com.android.application")
    kotlin("android")
}

val composeVersion = "1.0.1"

android {
    compileSdk = 30
    defaultConfig {
        applicationId = "app.salah.android"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.appcompat:appcompat:1.3.1")

    // jetpack compose
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.animation:animation:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
}