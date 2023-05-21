plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "1.4.0"
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

compose.experimental {
  web.application {}
}