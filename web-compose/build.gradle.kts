plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "1.4.0"
}

kotlin {
  js(IR) {
    browser()
    binaries.executable()
  }
  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(compose.web.core)
        implementation(compose.runtime)
        implementation(project(":shared"))
      }
    }
  }
}