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

    val iosMain by getting {
      dependencies {
        implementation("io.ktor:ktor-client-darwin:$ktorVersion")
      }
    }

    val iosTest by getting

    val iosSimulatorArm64Main by getting { dependsOn(iosMain) }
    val iosSimulatorArm64Test by getting { dependsOn(iosTest) }
  }

  // move kotlin-js-store directory under web-compose so it's not on the top level
  rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().lockFileDirectory =
      project.rootDir.resolve("web-compose/kotlin-js-store")
  }
}