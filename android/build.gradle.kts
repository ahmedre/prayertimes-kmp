plugins {
  id("com.android.application")
  kotlin("android")
  id("org.jetbrains.kotlin.plugin.compose") version "2.2.20"
}

android {
  namespace = "app.salah.android"

  compileSdk = 36
  defaultConfig {
    applicationId = "app.salah.android"
    minSdk = 21
    targetSdk = 36
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }

  buildFeatures.compose = true

  kotlinOptions {
    jvmTarget = "17"
    freeCompilerArgs = freeCompilerArgs + "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi"
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

kotlin {
  jvmToolchain(17)
}

dependencies {
  implementation(project(":shared"))
  implementation(project(":renderer"))
  implementation("androidx.appcompat:appcompat:1.7.1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

  // jetpack compose
  implementation(platform("androidx.compose:compose-bom:2025.10.00"))
  implementation("androidx.activity:activity-compose:1.11.0")
  implementation("androidx.compose.runtime:runtime")
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.foundation:foundation-layout")
  implementation("androidx.compose.material:material")
  implementation("androidx.compose.foundation:foundation")
  implementation("androidx.compose.animation:animation")
  implementation("androidx.compose.ui:ui-tooling")
}