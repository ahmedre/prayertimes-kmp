//
//  SalahTimesApp.swift
//  SalahTimes Watch App
//
//  Created by Ahmed El-Helw on 10/21/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

@main
struct SalahTimes_Watch_AppApp: App {
  var body: some Scene {
    WindowGroup {
      ContentView().environmentObject(PrayerTimesRespository())
    }
  }
}
