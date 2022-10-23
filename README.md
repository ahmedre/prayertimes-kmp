```
Kotlin Multiplatform

   ___                       _______                 ___           
  / _ \_______ ___ _____ ___/_  __(_)_ _  ___ ___   / _ | ___  ___ 
 / ___/ __/ _ `/ // / -_) __// / / /  ' \/ -_|_-<  / __ |/ _ \/ _ \
/_/  /_/  \_,_/\_, /\__/_/  /_/ /_/_/_/_/\__/___/ /_/ |_/ .__/ .__/
              /___/                                    /_/  /_/ 
```

This is a sample PrayerTimes App with shared business logic, initially written for a [talk](https://youtu.be/QaVVAYuVTe0) given for GDG MENA Digital Days on August 31st, 2021. The slide deck (10 slides, short since the talk was mostly live-coding) can be downloaded from [here](https://helw.dev/misc/kmp_prayertimes_slides-08.31.2021.pdf).

It uses the `kotlin_multiplatform` branch of [adhan](https://github.com/batoulapps/adhan-java/tree/kotlin_multiplatform) for shared PrayerTime calculation logic.

It was later modified to support more platforms as part of a talk, given in Arabic, at Droidcon Egypt in 2022.


## Features

* shared business logic between all platforms
* implementation for Android (using Jetpack Compose)
* implementation for iOS (using SwiftUI)
* implementation for desktop (using Jetpack Compose JVM)
* implementation for macOS
* implementation for watchOS
* implementation for command line (macOS, Linux, and Windows (untested)).


## Setup

1. Obtain a Google API key (see [here](https://developers.google.com/maps/documentation/geocoding/overview) for details).
2. Update `shared/src/commonMain/kotlin/app/salah/Secrets.kt` with your key.

On Android, open in Android Studio (Arctic Fox or above).
On iOS, open the xcworkspace file in Xcode.
