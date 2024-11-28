import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  kotlin("multiplatform")
  kotlin("native.cocoapods")
  id("com.android.library")
  id("org.jetbrains.compose") version "1.7.1"
  id("org.jetbrains.kotlin.plugin.compose") version "2.1.0"
}

version = "1.0"

kotlin {
  applyDefaultHierarchyTemplate()

  jvm()
  androidTarget {
    compilerOptions {
      jvmTarget.set(JvmTarget.JVM_17)
    }
  }

  js(IR) {
    browser()
  }

  iosX64()
  iosArm64()
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
  }
}

android {
  compileSdk = 35
  defaultConfig {
    minSdk = 21
  }

  namespace = "app.salah.renderer"

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}