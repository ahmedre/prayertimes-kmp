package app.salah

import kotlin.time.Instant


expect class PlatformDateFormatter() {
  fun formatDate(instant: Instant): String
}