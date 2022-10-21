//
//  osxApp.swift
//  osx
//
//  Created by Ahmed El-Helw on 10/21/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

@main
struct osxApp: App {
  var body: some Scene {
    WindowGroup {
      ContentView().environmentObject(PrayerTimesRespository())
    }
  }
}
