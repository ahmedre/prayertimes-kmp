//
//  PrayerTimesView.swift
//  ios
//
//  Created by Ahmed El-Helw on 8/30/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct PrayerTimesView: View {
    var salahTimes: SalahTimes

    var body: some View {
        VStack {
            Text(salahTimes.name)
            Text(salahTimes.fajr)
            Text(salahTimes.dhuhr)
            Text(salahTimes.asr)
            Text(salahTimes.maghrib)
            Text(salahTimes.isha)
        }
    }
}

struct PrayerTimesView_Previews: PreviewProvider {
    static var previews: some View {
        let salahTimes = SalahTimes(name: "Makkah", fajr: "3:59 am", dhuhr: "12:20pm", asr: "3:41pm", maghrib: "7:10pm", isha: "8:36pm")
        PrayerTimesView(salahTimes: salahTimes)
    }
}
