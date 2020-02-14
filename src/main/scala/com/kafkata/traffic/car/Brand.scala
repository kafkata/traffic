package com.kafkata.traffic.car

import com.kafkata.traffic.construction.Randoms

import scala.util.Random

sealed trait Brand

case object VW extends Brand
case object BMW extends Brand
case object Mercedes extends Brand
case object Peugeot extends Brand
case object Skoda extends Brand

object Brand {

	private val r = Random
	val AllBrands = Seq(VW, BMW, Mercedes, Peugeot, Skoda)

	def pickRandom(): Brand = {
		Randoms.pickRandomFrom(AllBrands)
	}

}


