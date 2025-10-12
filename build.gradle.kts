buildscript {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.20")
    classpath("com.android.tools.build:gradle:8.12.0")
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://central.sonatype.com/repository/maven-snapshots/") }
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  }
}