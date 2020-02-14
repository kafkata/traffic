package com.kafkata.traffic.car

import com.kafkata.traffic.construction.Randoms

case class Car(id: String, brand: Brand, numOfDoors: Int, colour: Color, weight: Int, petrolConsumption: Int)

object Car {

	def construct(id: Int): Car = {
		val brand = Brand.pickRandom()
		val color = Color.pickRandom()
		val numOfDoors = Randoms.pickRandomFrom(Seq(3,5))
		val weight = Randoms.pickRandomBetween(500, 1000)
		val petrolConsumption = Randoms.pickRandomBetween(4, 12)

		new Car(f"$id%07d", brand, numOfDoors, color, weight, petrolConsumption)
	}

}

