import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
  kotlin("multiplatform")
  kotlin("native.cocoapods")
  kotlin("plugin.serialization") version "2.2.20"
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

  val ktorVersion = "3.3.1"
  sourceSets {
    commonMain.dependencies {
        implementation("com.batoulapps.adhan:adhan2:0.0.6")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
        implementation("io.ktor:ktor-client-core:$ktorVersion")
        implementation("io.ktor:ktor-client-json:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization:$ktorVersion")
        implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
        implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
        implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    }

    commonTest.dependencies {
      implementation(kotlin("test-common"))
      implementation(kotlin("test-annotations-common"))
    }

    jvmMain.dependencies {
      implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    }

    jvmTest.dependencies {
      implementation(kotlin("test-junit"))
      implementation("junit:junit:4.13.2")
    }

    webMain.dependencies {
      implementation(npm("@js-joda/timezone", "2.21.1"))
    }

    jsMain.dependencies {
      implementation("io.ktor:ktor-client-js:$ktorVersion")
    }

    wasmJsMain.dependencies {
      implementation("io.ktor:ktor-client-cio:$ktorVersion")
    }

    val nativeMain by getting

    appleMain.dependencies {
      implementation("io.ktor:ktor-client-darwin:$ktorVersion")
    }

    if (isNonApple) {
      val nonAppleNativeMain by getting {
        dependsOn(nativeMain)
        dependencies {
          implementation("io.ktor:ktor-client-curl:$ktorVersion")
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