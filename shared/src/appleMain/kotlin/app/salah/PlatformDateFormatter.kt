package app.salah

import kotlinx.datetime.toNSDate
import platform.Foundation.NSDateFormatter
import kotlin.time.Instant

actual class PlatformDateFormatter actual constructor() {
  private val dateFormatter = NSDateFormatter().apply { dateFormat = "hh:mm a" }

  actual fun formatDate(instant: Instant): String {
    val date = instant.toNSDate()
    return dateFormatter.stringFromDate(date)
  }
}