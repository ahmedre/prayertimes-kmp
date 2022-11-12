package app.salah

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import app.salah.data.PrayerTimesRepository
import app.salah.view.PrayerTimesWrapperProvider

fun main() = application {
  val prayerTimesRepository = PrayerTimesRepository()

  Window(
    onCloseRequest = ::exitApplication,
    title = "PrayerTimes for Desktop",
    state = rememberWindowState(width = 300.dp, height = 300.dp)
  ) {
    PrayerTimesWrapperProvider.providePrayerTimesWrapper(prayerTimesRepository).invoke()
  }
}