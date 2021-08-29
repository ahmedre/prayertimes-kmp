package app.salah.api

import app.salah.GOOGLE_API_KEY
import app.salah.model.Location
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class LocationFetcher {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json { isLenient = true; ignoreUnknownKeys = true })
        }
    }
    private val geocodingApi = GeocodingApi(httpClient, GOOGLE_API_KEY)

    suspend fun getLocationFromName(where: String): Location? {
        return withContext(Dispatchers.Default) {
            val results = geocodingApi.geocode(where).results
            if (results.isNotEmpty()) {
                val firstResult = results.first()
                val coords = firstResult.geometry.location
                val countryCode =
                    firstResult.addressComponents.firstOrNull { it.types.contains("country") }?.shortName
                val timeZone = geocodingApi.timezone(coords.lat, coords.lng)
                Location(firstResult.formattedAddress, coords.lat, coords.lng, timeZone.timeZoneId, countryCode)
            } else {
                null
            }
        }
    }
}