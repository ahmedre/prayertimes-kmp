package app.salah.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import app.salah.data.PrayerTimesRepository
import app.salah.view.PrayerTimesWrapperProvider

class MainActivity : AppCompatActivity() {
  private val prayerTimesRepository = PrayerTimesRepository()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      PrayerTimesWrapperProvider.providePrayerTimesWrapper(prayerTimesRepository)
    }
  }
}
