package com.kafkata.traffic.car

import scala.util.Random

sealed trait Color

case object Green extends Color
case object Yellow extends Color
case object Black extends Color
case object Red extends Color
case object White extends Color

object Color {

	private val random = Random
	val AllColors = Seq(Green, Yellow, Black, Red, White)

	def pickRandom(): Color = {
		val pick = random.nextInt(AllColors.length)
		AllColors(pick)
	}

}
