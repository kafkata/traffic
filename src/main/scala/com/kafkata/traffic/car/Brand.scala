package com.kafkata.traffic.car

import com.kafkata.traffic.construction.Randoms

sealed trait Brand {
	val value: String
}

case object VW extends Brand {
	val value = "vw"
}

case object BMW extends Brand {
	val value = "bmw"
}

case object Mercedes extends Brand {
	val value = "mercedes"
}

case object Peugeot extends Brand {
	val value = "peugeot"
}

case object Skoda extends Brand {
	val value = "skoda"
}

object Brand {

  val AllBrands = Seq(VW, BMW, Mercedes, Peugeot, Skoda)

  def pickRandom(): String = {
    Randoms.pickRandomFrom(AllBrands).value
  }

}