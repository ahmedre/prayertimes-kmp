import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import app.salah.calculator.SalahCalculator
import app.salah.model.SalahTimes
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
  val calculator = SalahCalculator()
  renderComposable(rootElementId = "root") {
    val inputText = remember { mutableStateOf("") }
    val searchText = remember { mutableStateOf("") }
    val prayerTimes = remember { mutableStateOf<SalahTimes?>(null) }

    Div({ style { padding(25.px) } }) {
      Input(type = InputType.Text, attrs = {
        onInput { inputText.value = it.value }
        onKeyUp {
          if (it.key == "Enter") {
            searchText.value = inputText.value
          }
        }
      })

      Button(attrs = { onClick { searchText.value = inputText.value } }) {
        Text("Get Timings")
      }

      Div {
        val timings = prayerTimes.value
        if (timings != null) {
          Text(timings.name)
          PrayerTimesRow("Fajr", timings.fajr)
          PrayerTimesRow("Dhuhr", timings.dhuhr)
          PrayerTimesRow("Asr", timings.asr)
          PrayerTimesRow("Maghrib", timings.maghrib)
          PrayerTimesRow("Isha", timings.isha)
        }
      }
    }

    LaunchedEffect(searchText.value) {
      val query = searchText.value
      prayerTimes.value = if (query.isBlank()) {
        null
      } else {
        calculator.prayerTimes(query)
      }
    }
  }
}