import SwiftUI
import shared

struct ContentView: View {
  @State private var text = ""
  @EnvironmentObject var prayerTimeRepository: PrayerTimesRespository
  
  var body: some View {
    VStack {
      TextField("Enter a Location",
                text: $text,
                onCommit: { prayerTimeRepository.search(name: text) }
      ).padding()
      
      Spacer()
      
      VStack(alignment: .center) {
        if let salahTime = prayerTimeRepository.result {
          PrayerTimesView(salahTimes: salahTime)
        } else {
          Text("Unknown Location")
        }
      }
      
      Spacer()
    }
  }
}

struct ContentView_Previews: PreviewProvider {
  static var previews: some View {
    ContentView().environmentObject(PrayerTimesRespository())
  }
}
