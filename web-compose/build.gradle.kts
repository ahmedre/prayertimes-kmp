plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "1.2.1"
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