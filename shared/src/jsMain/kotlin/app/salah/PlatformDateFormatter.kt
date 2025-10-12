package app.salah

import kotlin.time.Instant
import kotlin.time.toJSDate

actual class PlatformDateFormatter actual constructor() {
  actual fun formatDate(instant: Instant): String {
    return instant.toJSDate().toLocaleTimeString()
  }
}