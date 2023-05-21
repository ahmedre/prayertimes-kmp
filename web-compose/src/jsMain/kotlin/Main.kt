import app.salah.data.PrayerTimesRepository
import app.salah.view.PrayerTimesWrapperProvider
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
  val prayerTimesRepository = PrayerTimesRepository()
  onWasmReady {
    BrowserViewportWindow("PrayerTimes") {
      PrayerTimesWrapperProvider.providePrayerTimesWrapper(prayerTimesRepository).invoke()
    }
  }
}