```
Kotlin Multiplatform

   ___                       _______                 ___           
  / _ \_______ ___ _____ ___/_  __(_)_ _  ___ ___   / _ | ___  ___ 
 / ___/ __/ _ `/ // / -_) __// / / /  ' \/ -_|_-<  / __ |/ _ \/ _ \
/_/  /_/  \_,_/\_, /\__/_/  /_/ /_/_/_/_/\__/___/ /_/ |_/ .__/ .__/
              /___/                                    /_/  /_/ 
```

This is a sample PrayerTimes App with shared business logic written for a [talk](https://youtu.be/QaVVAYuVTe0) given for GDG MENA Digital Days.

It uses the `kotlin_multiplatform` branch of [adhan](https://github.com/batoulapps/adhan-java/tree/kotlin_multiplatform) for shared PrayerTime calculation logic.


## Features

* shared business logic between iOS and Android
* implementation for Android (using Jetpack Compose)
* implementation for iOS (using SwiftUI)


## Setup

1. Obtain a Google API key (see [here](https://developers.google.com/maps/documentation/geocoding/overview) for details).
2. Update `shared/src/commonMain/kotlin/app/salah/Secrets.kt` with your key.

On Android, open in Android Studio (Arctic Fox or above).
On iOS, open the xcworkspace file in Xcode.
