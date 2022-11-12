plugins {
  id("com.android.application")
  kotlin("android")
}

val composeVersion = "1.2.1"
val composeCompilerVersion = "1.3.2"

android {
  compileSdk = 33
  defaultConfig {
    applicationId = "app.salah.android"
    minSdk = 21
    targetSdk = 33
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
    kotlinCompilerExtensionVersion = composeCompilerVersion
  }

  kotlinOptions {
    jvmTarget = "1.8"
    freeCompilerArgs = freeCompilerArgs + "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi"
  }
}

dependencies {
  implementation(project(":shared"))
  implementation(project(":renderer"))
  implementation("androidx.appcompat:appcompat:1.5.1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

  // jetpack compose
  implementation("androidx.activity:activity-compose:1.6.1")
  implementation("androidx.compose.runtime:runtime:$composeVersion")
  implementation("androidx.compose.ui:ui:$composeVersion")
  implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
  implementation("androidx.compose.material:material:$composeVersion")
  implementation("androidx.compose.foundation:foundation:$composeVersion")
  implementation("androidx.compose.animation:animation:$composeVersion")
  implementation("androidx.compose.ui:ui-tooling:$composeVersion")
}