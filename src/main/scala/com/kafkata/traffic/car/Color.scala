package com.kafkata.traffic.car

import com.kafkata.traffic.construction.Randoms

sealed trait Color {
  val value: String
}

case object Green extends Color {
	val value: String = "green"
}

case object Yellow extends Color {
	val value: String = "yellow"
}

case object Black extends Color {
	val value: String = "black"
}

case object Red extends Color {
	val value: String = "red"
}

case object White extends Color {
	val value: String = "white"
}

object Color {

  val AllColors = Seq(Green, Yellow, Black, Red, White)

  def pickRandom(): String = {
    Randoms.pickRandomFrom(AllColors).value
  }

}
