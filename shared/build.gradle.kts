plugins {
  kotlin("multiplatform")
  kotlin("native.cocoapods")
  kotlin("plugin.serialization") version "1.7.10"
}

version = "1.0"

kotlin {
  jvm()

  js(IR) {
    useCommonJs()
    browser()
  }

  ios()
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

  watchos()
  watchosSimulatorArm64()

  cocoapods {
    summary = "Some description for the Shared Module"
    homepage = "Link to the Shared Module homepage"
  }

  val ktorVersion = "2.1.1"
  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation("com.batoulapps.adhan:adhan2:0.0.4")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        implementation("io.ktor:ktor-client-core:$ktorVersion")
        implementation("io.ktor:ktor-client-json:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization:$ktorVersion")
        implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
        implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
        implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
      }
    }

    val commonTest by getting {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }

    val jvmMain by getting {
      dependencies {
        implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test-junit"))
        implementation("junit:junit:4.13.2")
      }
    }

    val jsMain by getting {
      dependencies {
        implementation(npm("@js-joda/timezone", "2.3.0"))
        implementation("io.ktor:ktor-client-js:$ktorVersion")
      }
    }

    val nativeMain by creating {
      dependsOn(commonMain)
    }

    val appleMain by creating {
      dependsOn(nativeMain)
      dependencies {
        implementation("io.ktor:ktor-client-darwin:$ktorVersion")
      }
    }

    val appleTest by creating {
      dependsOn(commonTest)
    }

    if (isNonApple) {
      val nonAppleNativeMain by getting {
        dependsOn(nativeMain)
        dependencies {
          implementation("io.ktor:ktor-client-curl:$ktorVersion")
        }
      }
    } else {
      val macosArm64Main by getting { dependsOn(appleMain) }
      val macosArm64Test by getting { dependsOn(appleTest) }
    }

    val iosMain by getting { dependsOn(appleMain) }
    val iosTest by getting { dependsOn(appleTest) }

    val iosSimulatorArm64Main by getting { dependsOn(appleMain) }
    val iosSimulatorArm64Test by getting { dependsOn(appleTest) }

    val watchosMain by getting { dependsOn(appleMain) }
    val watchosTest by getting { dependsOn(appleTest) }
    val watchosSimulatorArm64Main by getting { dependsOn(appleMain) }
    val watchosSimulatorArm64Test by getting { dependsOn(appleTest) }
  }

  // move kotlin-js-store directory under web-compose so it's not on the top level
  rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().lockFileDirectory =
      project.rootDir.resolve("web-compose/kotlin-js-store")
  }
}