package app.salah.api

import app.salah.api.model.GeocodingResult
import app.salah.api.model.TimezoneModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.datetime.Clock

class GeocodingApi(private val httpClient: HttpClient, private val apiKey: String) {
    private val baseUrl = "https://maps.googleapis.com/maps/api/geocode/json"

    suspend fun geocode(name: String) =
        httpClient.get<GeocodingResult>(baseUrl) {
            parameter("address", name)
            parameter("key", apiKey)
        }

    private val timeBaseUrl = "https://maps.googleapis.com/maps/api/timezone/json"

    suspend fun timezone(latitude: Double, longitude: Double) =
        httpClient.get<TimezoneModel>(timeBaseUrl) {
            parameter("location", "$latitude,$longitude")
            parameter("timestamp", Clock.System.now().epochSeconds)
            parameter("key", apiKey)
        }
}