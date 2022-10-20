plugins {
  kotlin("multiplatform")
  id("com.android.library")
  id("org.jetbrains.compose") version "1.2.0"
}

version = "1.0"

kotlin {
  jvm()
  android()

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(compose.ui)
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.material)
        implementation(project(":shared"))
      }
    }

    val commonTest by getting {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }
  }
}

android {
  compileSdk = 33
  defaultConfig {
    minSdk = 21
    targetSdk = 33
  }

  namespace = "app.salah.renderer"

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}