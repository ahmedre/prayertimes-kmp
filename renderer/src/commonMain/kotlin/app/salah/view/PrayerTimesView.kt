package app.salah.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.salah.model.SalahTimes

@Composable
internal fun PrayerTimesView(salahTimes: SalahTimes) {
  Column(modifier = Modifier.padding(16.dp)) {
    Text(salahTimes.name)
    Text(salahTimes.fajr)
    Text(salahTimes.dhuhr)
    Text(salahTimes.asr)
    Text(salahTimes.maghrib)
    Text(salahTimes.isha)
  }
}