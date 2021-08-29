package app.salah

import kotlinx.datetime.Instant

expect class PlatformDateFormatter() {
    fun formatDate(instant: Instant): String
}