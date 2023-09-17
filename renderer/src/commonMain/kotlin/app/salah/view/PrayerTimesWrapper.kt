package app.salah.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import app.salah.data.PrayerTimesRepository

@Composable
fun PrayerTimesWrapper(prayerTimesRepository: PrayerTimesRepository, modifier: Modifier = Modifier) {
  MaterialTheme {
    val prayerTimesState = prayerTimesRepository.prayerTimesFlow.collectAsState()

    Column(modifier = modifier) {
      SearchBar(onLocationChanged = { prayerTimesRepository.search(it) })
      val prayerTimes = prayerTimesState.value
      if (prayerTimes != null) {
        PrayerTimesView(salahTimes = prayerTimes)
      }
    }
  }
}