import app.salah.calculator.SalahCalculator
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
  val placeName = args.firstOrNull() ?: "Cairo"

  val calculator = SalahCalculator()
  val prayerTimes = runBlocking { calculator.prayerTimes(placeName) }
  if (prayerTimes != null) {
    println(prayerTimes.name)
    println("Fajr: " + prayerTimes.fajr)
    println("Dhuhr: " + prayerTimes.dhuhr)
    println("Asr: " + prayerTimes.asr)
    println("Maghrib: " + prayerTimes.maghrib)
    println("Isha: " + prayerTimes.isha)
  }
}