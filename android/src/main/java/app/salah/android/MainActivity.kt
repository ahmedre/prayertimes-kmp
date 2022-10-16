package app.salah.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
import app.salah.android.data.PrayerTimesRepository
import app.salah.android.view.PrayerTimesView
import app.salah.android.view.SearchBar

class MainActivity : AppCompatActivity() {
  private val prayerTimesRepository = PrayerTimesRepository()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      MaterialTheme {
        val prayerTimesState = prayerTimesRepository.prayerTimesFlow.collectAsState()

        Column {
          SearchBar(onLocationChanged = { prayerTimesRepository.search(it) })
          val prayerTimes = prayerTimesState.value
          if (prayerTimes != null) {
            PrayerTimesView(salahTimes = prayerTimes)
          }
        }
      }
    }
  }
}
