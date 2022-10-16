package app.salah.calculator

import app.salah.PlatformDateFormatter
import app.salah.api.LocationFetcher
import app.salah.model.SalahTimes
import com.batoulapps.adhan2.CalculationMethod
import com.batoulapps.adhan2.CalculationParameters
import com.batoulapps.adhan2.Coordinates
import com.batoulapps.adhan2.Madhab
import com.batoulapps.adhan2.PrayerTimes
import com.batoulapps.adhan2.data.DateComponents
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

class SalahCalculator {
  private val dateFormatter = PlatformDateFormatter()
  private val locationFetcher = LocationFetcher()

  suspend fun prayerTimes(placeName: String): SalahTimes? {
    val loc = locationFetcher.getLocationFromName(placeName)
    val location = loc ?: return null

    val coordinates = Coordinates(location.latitude, location.longitude)

    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val dateComponents = DateComponents(now.year, now.monthNumber, now.dayOfMonth)

    val calculationMethod = calculationParameters(location.countryCode)
    val prayerTimes = PrayerTimes(coordinates, dateComponents, calculationMethod)

    val timeZone = TimeZone.of(location.timezone)
    return SalahTimes(
      name = location.name,
      fajr = prayerTimes.fajr.convertToLocalSnapshotOfTimezone(timeZone),
      dhuhr = prayerTimes.dhuhr.convertToLocalSnapshotOfTimezone(timeZone),
      asr = prayerTimes.asr.convertToLocalSnapshotOfTimezone(timeZone),
      maghrib = prayerTimes.maghrib.convertToLocalSnapshotOfTimezone(timeZone),
      isha = prayerTimes.isha.convertToLocalSnapshotOfTimezone(timeZone)
    )
  }

  private fun calculationParameters(countryCode: String?): CalculationParameters {
    return when (countryCode?.lowercase()) {
      "sa" -> CalculationMethod.UMM_AL_QURA.parameters
      "ae" -> CalculationMethod.DUBAI.parameters
      "eg" -> CalculationMethod.EGYPTIAN.parameters
      "kw" -> CalculationMethod.KUWAIT.parameters
      "pk" -> CalculationMethod.KARACHI.parameters.copy(madhab = Madhab.HANAFI)
      "qa" -> CalculationMethod.QATAR.parameters
      "sg" -> CalculationMethod.SINGAPORE.parameters
      "us" -> CalculationMethod.NORTH_AMERICA.parameters
      else -> CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
    }
  }

  private fun Instant.convertToLocalSnapshotOfTimezone(timeZone: TimeZone) =
    toLocalDateTime(timeZone).toInstant(TimeZone.currentSystemDefault()).stringify()

  private fun Instant.stringify() = dateFormatter.formatDate(this)
}