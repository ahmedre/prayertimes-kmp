package app.salah.android.data

import app.salah.calculator.SalahCalculator
import app.salah.model.SalahTimes
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PrayerTimesRepository {
  private val _prayerTimesFlow = MutableStateFlow<SalahTimes?>(null)
  val prayerTimesFlow = _prayerTimesFlow.asStateFlow()
  private val salahCalculator = SalahCalculator()
  private val scope = MainScope()

  fun search(location: String) {
    scope.launch {
      _prayerTimesFlow.value = salahCalculator.prayerTimes(location)
    }
  }
}