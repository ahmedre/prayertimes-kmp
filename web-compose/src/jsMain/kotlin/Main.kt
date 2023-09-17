import app.salah.data.PrayerTimesRepository
import app.salah.view.PrayerTimesWrapper
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
  val prayerTimesRepository = PrayerTimesRepository()
  onWasmReady {
    BrowserViewportWindow("PrayerTimes") {
      PrayerTimesWrapper(prayerTimesRepository)
    }
  }
}