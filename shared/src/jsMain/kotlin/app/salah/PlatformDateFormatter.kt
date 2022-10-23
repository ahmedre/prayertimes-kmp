package app.salah

import kotlinx.datetime.Instant
import kotlinx.datetime.toJSDate

actual class PlatformDateFormatter actual constructor() {
  actual fun formatDate(instant: Instant): String {
    return instant.toJSDate().toLocaleTimeString()
  }
}