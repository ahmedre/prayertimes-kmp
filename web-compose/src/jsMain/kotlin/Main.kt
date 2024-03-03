import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import app.salah.data.PrayerTimesRepository
import app.salah.view.PrayerTimesWrapper
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  val prayerTimesRepository = PrayerTimesRepository()
  onWasmReady {
    CanvasBasedWindow("PrayerTimes") {
      PrayerTimesWrapper(prayerTimesRepository)
    }
  }
}