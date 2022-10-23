package app.salah

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

actual class PlatformDateFormatter actual constructor() {

    actual fun formatDate(instant: Instant): String {
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "" + localTime.hour + ":" + localTime.minute.toString().padStart(2, '0')
    }
}