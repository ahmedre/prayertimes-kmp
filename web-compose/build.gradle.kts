import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose.multiplatform)
  alias(libs.plugins.kotlin.compose)
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
      implementation(libs.compose.ui)
      implementation(libs.compose.runtime)
      implementation(libs.compose.foundation)
      implementation(project(":shared"))
      implementation(project(":renderer"))
    }
  }
}
