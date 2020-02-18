package com.kafkata.traffic

import com.kafkata.traffic.construction.Randoms
import org.gavaghan.geodesy.{Ellipsoid, GeodeticCalculator, GlobalPosition}
import play.api.libs.json.{Format, Json}

case class Position(latitude: Double, // Latitude in degrees. Negative latitude is southern hemisphere
                    longitude: Double) { // Longitude in degrees. Negative longitude is western hemisphere

  def distanceInKilometersTo(position: Position): Double = {
    def toGlobalPosition(pos: Position): GlobalPosition = {
      new GlobalPosition(pos.latitude, pos.longitude, 0)
    }

    val geodeticMeasurement = Position.GeodeticCalculator.calculateGeodeticMeasurement(
      Position.EarthEllipsoid, toGlobalPosition(this), toGlobalPosition(position)
    )
    geodeticMeasurement.getPointToPointDistance / 1000
  }

}

object Position {

  // see https://github.com/mgavaghan/geodesy
  val GeodeticCalculator: GeodeticCalculator = new GeodeticCalculator
  val EarthEllipsoid: Ellipsoid = Ellipsoid.WGS84
  implicit val dataPointFormat: Format[Position] = Json.format[Position]

  def random(): Position = {
    Position(
      Randoms.pickRandomBetween(-90, 90),
      Randoms.pickRandomBetween(-180, 180)
    )
  }
}
