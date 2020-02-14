package com.kafkata.traffic.car

import scala.util.Random

object Color {
	sealed trait EnumVal
	case object Green extends EnumVal
	case object Yellow extends EnumVal
	case object Black extends EnumVal
	case object Red extends EnumVal
	case object White extends EnumVal

	val allColors = Seq(Green, Yellow, Black, Red, White)

	def pickRandom(): EnumVal = {
		val r = Random
		val pick = r.nextInt(allColors.length)
		allColors(pick)
	}
}
