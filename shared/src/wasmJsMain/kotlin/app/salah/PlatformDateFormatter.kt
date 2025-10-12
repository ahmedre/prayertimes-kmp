package app.salah

import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

actual class PlatformDateFormatter actual constructor() {
  actual fun formatDate(instant: Instant): String {
    return instant.toLocalDateTime(TimeZone.currentSystemDefault()).time.format(LocalTime.Formats.ISO)
  }
}