plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "1.7.1"
  id("org.jetbrains.kotlin.plugin.compose") version "2.1.0"
}

kotlin {
  js(IR) {
    moduleName = "web-compose"
    browser()
    binaries.executable()
  }
  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(compose.ui)
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(project(":shared"))
        implementation(project(":renderer"))
      }
    }
  }
}