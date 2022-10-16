package app.salah

import kotlinx.datetime.Instant
import java.text.SimpleDateFormat
import java.util.*

actual class PlatformDateFormatter actual constructor() {
  private val dateFormatter = SimpleDateFormat.getTimeInstance(SimpleDateFormat.SHORT)

  actual fun formatDate(instant: Instant): String {
    return dateFormatter.format(Date(instant.toEpochMilliseconds()))
  }
}