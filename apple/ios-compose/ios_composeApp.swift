//
//  ios_composeApp.swift
//  ios-compose
//
//  Created by Ahmed El-Helw on 10/21/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import UIKit
import renderer

@main
class AppDelegate: UIResponder, UIApplicationDelegate {
  var window: UIWindow?
  
  func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
    window = UIWindow(frame: UIScreen.main.bounds)
    
    window?.rootViewController = ComposeRootController.shared.rootController()
    window?.makeKeyAndVisible()
    return true
  }
}
