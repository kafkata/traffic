package com.kafkata.traffic

import com.kafkata.traffic.car.{Brand, Color}

import scala.util.Random

// TODO id -> uuid
case class Car(id: String, brand: Brand, numOfDoors: Int, colour: Color, weight: Int, gasMileage: Int)

object Car {
	def pickRandomFrom(vs: Seq[Int]): Int = {
		val r = Random
		val pick = r.nextInt(vs.length)
		vs(pick)
	}

	def apply(id: Int): Car = {

		val brand = Brand.pickRandom()
		val color = Color.pickRandom()
		val numOfDoors = pickRandomFrom(Seq(3,5))

		new Car(s"#$id", brand, numOfDoors, color, 900, 4)
	}
}

