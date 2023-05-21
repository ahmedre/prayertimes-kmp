plugins {
  id("com.android.application")
  kotlin("android")
}

val composeCompilerVersion = "1.4.6"

android {
  namespace = "app.salah.android"

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
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

  // jetpack compose
  implementation(platform("androidx.compose:compose-bom:2023.05.01"))
  implementation("androidx.activity:activity-compose:1.7.1")
  implementation("androidx.compose.runtime:runtime")
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.foundation:foundation-layout")
  implementation("androidx.compose.material:material")
  implementation("androidx.compose.foundation:foundation")
  implementation("androidx.compose.animation:animation")
  implementation("androidx.compose.ui:ui-tooling")
}