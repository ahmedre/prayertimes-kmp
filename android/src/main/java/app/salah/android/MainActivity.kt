package app.salah.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import app.salah.data.PrayerTimesRepository
import app.salah.view.PrayerTimesWrapper

class MainActivity : AppCompatActivity() {
    private val prayerTimesRepository = PrayerTimesRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PrayerTimesWrapper(
                prayerTimesRepository,
                modifier = Modifier.windowInsetsPadding(
                  WindowInsets.systemBars.union(WindowInsets.displayCutout)
                )
            )
        }
    }
}
