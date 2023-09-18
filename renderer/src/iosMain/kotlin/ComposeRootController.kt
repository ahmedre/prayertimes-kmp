import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import app.salah.data.PrayerTimesRepository
import app.salah.view.PrayerTimesWrapper

object ComposeRootController {
  fun rootController() = ComposeUIViewController {
    PrayerTimesWrapper(PrayerTimesRepository(), Modifier.padding(top = 48.dp))
  }
}