pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "salah"
include(":android")
include(":shared")
include(":desktop")
include(":renderer")
include(":web-compose")
