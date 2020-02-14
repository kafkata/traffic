package com.kafkata.traffic

import com.kafkata.traffic.construction.Randoms
import play.api.libs.json.{Format, Json}

case class Position(x: Int, y: Int)

object Position {

	implicit val dataPointFormat: Format[Position] = Json.format[Position]

	def random(): Position = {
		Position(
			Randoms.pickRandomBetween(-1000, 1000),
			Randoms.pickRandomBetween(-1000, 1000)
		)
	}
}
