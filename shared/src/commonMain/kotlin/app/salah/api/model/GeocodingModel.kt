package app.salah.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeocodingResult(
  val results: List<Result>,
  val status: String
)

@Serializable
data class Result(
  @SerialName("address_components") val addressComponents: List<AddressComponent>,
  @SerialName("formatted_address") val formattedAddress: String,
  val geometry: Geometry
)

@Serializable
data class AddressComponent(
  @SerialName("long_name") val longName: String,
  @SerialName("short_name") val shortName: String,
  val types: List<String>
)

@Serializable
data class Geometry(
  val location: GeometryCoordinates,
  @SerialName("location_type") val locationType: String,
)

@Serializable
data class GeometryCoordinates(
  val lat: Double,
  val lng: Double
)