package app.salah.api

import app.salah.api.model.GeocodingResult
import app.salah.api.model.TimezoneModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.datetime.Clock

class GeocodingApi(private val httpClient: HttpClient, private val apiKey: String) {
    private val baseUrl = "https://maps.googleapis.com/maps/api/geocode/json"

    suspend fun geocode(name: String): GeocodingResult =
        httpClient.get(baseUrl) {
            parameter("address", name)
            parameter("key", apiKey)
        }.body()

    private val timeBaseUrl = "https://maps.googleapis.com/maps/api/timezone/json"

    suspend fun timezone(latitude: Double, longitude: Double): TimezoneModel =
        httpClient.get(timeBaseUrl) {
            parameter("location", "$latitude,$longitude")
            parameter("timestamp", Clock.System.now().epochSeconds)
            parameter("key", apiKey)
        }.body()
}