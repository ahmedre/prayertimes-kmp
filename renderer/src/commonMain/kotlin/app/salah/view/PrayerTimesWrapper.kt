package app.salah.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import app.salah.data.PrayerTimesRepository

@Composable
internal fun PrayerTimesWrapper(prayerTimesRepository: PrayerTimesRepository, modifier: Modifier) {
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

object PrayerTimesWrapperProvider {
  fun providePrayerTimesWrapper(
    prayerTimesRepository: PrayerTimesRepository,
    modifier: Modifier = Modifier
  ): (@Composable () -> Unit) = {
    PrayerTimesWrapper(prayerTimesRepository, modifier)
  }
}