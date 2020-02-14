package com.kafkata.traffic.car

import com.kafkata.traffic.construction.Randoms
import play.api.libs.json.{Format, Json}


case class Car(id: String, brand: String, numOfDoors: Int, color: String, weight: Int, petrolConsumption: Int)

object Car {

	implicit val carFormat: Format[Car] = Json.format[Car]

	def construct(id: Int): Car = {
		val brand = Brand.pickRandom()
		val color = Color.pickRandom()
		val numOfDoors = Randoms.pickRandomFrom(Seq(3,5))
		val weight = Randoms.pickRandomBetween(500, 1000)
		val petrolConsumption = Randoms.pickRandomBetween(4, 12)

		new Car(f"$id%07d", brand, numOfDoors, color, weight, petrolConsumption)
	}

}

