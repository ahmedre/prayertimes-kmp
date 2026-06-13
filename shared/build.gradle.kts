import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.kotlin.cocoapods)
  alias(libs.plugins.kotlin.serialization)
}

version = "1.0"

kotlin {
  applyDefaultHierarchyTemplate()

  jvm()

  js(IR) {
    useCommonJs()
    browser()
  }

  @OptIn(ExperimentalWasmDsl::class)
  wasmJs {
    browser()
  }

  iosX64()
  iosArm64()
  iosSimulatorArm64()

  val hostOs = System.getProperty("os.name")
  val nativeTarget = when {
    hostOs == "Mac OS X" -> macosArm64()
    hostOs == "Linux" -> linuxX64("nonAppleNative")
    hostOs.startsWith("Windows") -> mingwX64("nonAppleNative")
    else -> null
  }
  val isNonApple = hostOs != null && hostOs != "Mac OS X"

  nativeTarget?.binaries?.executable { entryPoint = "main" }

  watchosArm32()
  watchosArm64()
  watchosSimulatorArm64()

  cocoapods {
    summary = "Some description for the Shared Module"
    homepage = "Link to the Shared Module homepage"

    framework {
      isStatic = true
    }
  }

  compilerOptions {
    optIn.add("kotlin.time.ExperimentalTime")
  }

  sourceSets {
    commonMain.dependencies {
      implementation(libs.adhan)
      implementation(libs.kotlinx.coroutines.core)
      implementation(libs.ktor.client.core)
      implementation(libs.ktor.client.json)
      implementation(libs.ktor.client.serialization)
      implementation(libs.ktor.client.content.negotiation)
      implementation(libs.ktor.serialization.kotlinx.json)
    }

    commonTest.dependencies {
      implementation(kotlin("test-common"))
      implementation(kotlin("test-annotations-common"))
    }

    jvmMain.dependencies {
      implementation(libs.ktor.client.okhttp)
    }

    jvmTest.dependencies {
      implementation(kotlin("test-junit"))
      implementation(libs.junit)
    }

    webMain.dependencies {
      implementation(npm("@js-joda/timezone", libs.versions.timezone.get()))
    }

    jsMain.dependencies {
      implementation(libs.ktor.client.js)
    }

    wasmJsMain.dependencies {
      implementation(libs.ktor.client.cio)
    }

    val nativeMain by getting

    appleMain.dependencies {
      implementation(libs.ktor.client.darwin)
    }

    if (isNonApple) {
      val nonAppleNativeMain by getting {
        dependsOn(nativeMain)
        dependencies {
          implementation(libs.ktor.client.curl)
        }
      }
    }
  }

  // move kotlin-js-store directory under web-compose so it's not on the top level
  rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().lockFileDirectory =
      project.rootDir.resolve("web-compose/kotlin-js-store")
  }
}
