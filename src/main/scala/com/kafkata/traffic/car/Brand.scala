package com.kafkata.traffic.car

import scala.util.Random

object Brand {
	sealed trait EnumVal
	case object VW extends EnumVal
	case object BMW extends EnumVal
	case object Mercedes extends EnumVal
	case object Peugeot extends EnumVal
	case object Skoda extends EnumVal

	val allBrands = Seq(VW, BMW, Mercedes, Peugeot, Skoda)

	def pickRandom(): EnumVal = {
		val r = Random
		val pick = r.nextInt(allBrands.length)
		allBrands(pick)
	}
}
