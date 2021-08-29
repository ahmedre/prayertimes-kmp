package app.salah.model

data class Location(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val countryCode: String?
)