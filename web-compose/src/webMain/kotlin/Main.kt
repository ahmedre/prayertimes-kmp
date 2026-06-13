import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import app.salah.data.PrayerTimesRepository
import app.salah.view.PrayerTimesWrapper

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val prayerTimesRepository = PrayerTimesRepository()
    ComposeViewport(viewportContainerId = "ComposeTarget", content = {
        PrayerTimesWrapper(prayerTimesRepository)
    })
}