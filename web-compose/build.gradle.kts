import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "1.9.0"
  id("org.jetbrains.kotlin.plugin.compose") version "2.2.20"
}

kotlin {
  js(IR) {
    browser()
    binaries.executable()
  }

  @OptIn(ExperimentalWasmDsl::class)
  wasmJs {
    browser()
    binaries.executable()
  }

  sourceSets {
    webMain.dependencies {
      implementation(compose.ui)
      implementation(compose.runtime)
      implementation(compose.foundation)
      implementation(project(":shared"))
      implementation(project(":renderer"))
    }
  }
}