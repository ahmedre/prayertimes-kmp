import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.kotlin.cocoapods)
  alias(libs.plugins.android.kmp.library)
  alias(libs.plugins.compose.multiplatform)
  alias(libs.plugins.kotlin.compose)
}

version = "1.0"

kotlin {
  applyDefaultHierarchyTemplate()

  jvm()
  android {
    namespace = "app.salah.renderer"
    compileSdk = libs.versions.compileSdk.get().toInt()
    minSdk = libs.versions.minSdk.get().toInt()

    compilerOptions {
      jvmTarget.set(JvmTarget.JVM_17)
    }
  }

  js {
    browser()
  }

  @OptIn(ExperimentalWasmDsl::class)
  wasmJs {
    browser()
  }

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
    commonMain.dependencies {
      implementation(libs.compose.ui)
      implementation(libs.compose.runtime)
      implementation(libs.compose.foundation)
      implementation(libs.compose.material)
      implementation(project(":shared"))
    }

    commonTest.dependencies {
      implementation(kotlin("test-common"))
      implementation(kotlin("test-annotations-common"))
    }
  }
}
