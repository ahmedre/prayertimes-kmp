package app.salah.api.model

import kotlinx.serialization.Serializable

@Serializable
data class TimezoneModel(
    val dstOffset: Int,
    val rawOffset: Int,
    val status: String,
    val timeZoneId: String,
    val timeZoneName: String
)