//
//  PrayerTimesRepository.swift
//  ios
//
//  Created by Ahmed El-Helw on 8/30/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class PrayerTimesRespository: ObservableObject {
    @Published var result: SalahTimes? = nil
    private let salahCalculator = SalahCalculator()

    func search(name: String) {
        self.salahCalculator.prayerTimes(placeName: name,
                                         completionHandler:
                                            { result, error in
                                                if let actualResult = result {
                                                    self.result = actualResult
                                                }
                                            })
    }
}
