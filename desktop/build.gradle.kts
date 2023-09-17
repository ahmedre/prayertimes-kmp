import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "1.5.1"
}

kotlin {
  jvm { withJava() }

  sourceSets {
    named("jvmMain") {
      dependencies {
        implementation(project(":shared"))
        implementation(project(":renderer"))
        implementation(compose.desktop.currentOs)
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.7.3")
      }
    }
  }
}

compose.desktop {
  application {
    mainClass = "app.salah.MainKt"
    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Deb)
      packageName = "SalahTimesDesktop"
      packageVersion = "1.0.0"

      windows {
        menuGroup = "Salah Times Demo"
        // see https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
        upgradeUuid = "BDC90727-A0B7-49E8-9809-7B02B505E915"
      }
    }
  }
}
