import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import app.salah.data.PrayerTimesRepository
import app.salah.view.PrayerTimesWrapper

object ComposeRootController {
  fun rootController() = Application("PrayerTimes") {
    PrayerTimesWrapper(PrayerTimesRepository(), Modifier.padding(top = 48.dp))
  }
}