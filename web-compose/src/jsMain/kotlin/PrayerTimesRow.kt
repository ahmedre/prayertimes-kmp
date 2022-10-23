import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun PrayerTimesRow(label: String, value: String) {
  Div {
    Span(attrs = {
      style {
        fontWeight("bold")
        paddingRight(4.px)
      }
    }) {
      Text(label)
    }
    Text(value)
  }
}