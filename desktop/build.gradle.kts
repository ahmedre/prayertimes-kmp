import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose.multiplatform)
  alias(libs.plugins.kotlin.compose)
}

kotlin {
  jvm()

  sourceSets {
    named("jvmMain") {
      dependencies {
        implementation(project(":shared"))
        implementation(project(":renderer"))
        implementation(compose.desktop.currentOs)
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.swing)
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
