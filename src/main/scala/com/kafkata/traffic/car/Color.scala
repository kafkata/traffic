package com.kafkata.traffic.car

import com.kafkata.traffic.construction.Randoms

sealed trait Color

case object Green extends Color
case object Yellow extends Color
case object Black extends Color
case object Red extends Color
case object White extends Color

object Color {

	val AllColors = Seq(Green, Yellow, Black, Red, White)

	def pickRandom(): Color = {
		Randoms.pickRandomFrom(AllColors)
	}

}
