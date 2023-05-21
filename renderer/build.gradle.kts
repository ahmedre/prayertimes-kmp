plugins {
  kotlin("multiplatform")
  kotlin("native.cocoapods")
  id("com.android.library")
  id("org.jetbrains.compose") version "1.4.0"
}

version = "1.0"

kotlin {
  jvm()
  android()

  ios()
  iosSimulatorArm64()

  cocoapods {
    summary = "Some description for the Renderer Module"
    homepage = "Link to the Renderer Module homepage"

    framework {
      isStatic = true
    }
  }

  // disable checks due to compose iOS issues with LLVM in the current version
  targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
    binaries.all {
      freeCompilerArgs = freeCompilerArgs + "-Xdisable-phases=VerifyBitcode"
    }
  }

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

    val iosMain by getting
    val iosSimulatorArm64Main by getting { dependsOn(iosMain) }
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
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}