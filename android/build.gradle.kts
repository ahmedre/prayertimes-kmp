plugins {
  id("com.android.application")
  kotlin("android")
}

val composeCompilerVersion = "1.5.3"

android {
  namespace = "app.salah.android"

  compileSdk = 34
  defaultConfig {
    applicationId = "app.salah.android"
    minSdk = 21
    targetSdk = 34
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
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

  // jetpack compose
  implementation(platform("androidx.compose:compose-bom:2023.09.00"))
  implementation("androidx.activity:activity-compose:1.7.2")
  implementation("androidx.compose.runtime:runtime")
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.foundation:foundation-layout")
  implementation("androidx.compose.material:material")
  implementation("androidx.compose.foundation:foundation")
  implementation("androidx.compose.animation:animation")
  implementation("androidx.compose.ui:ui-tooling")
}