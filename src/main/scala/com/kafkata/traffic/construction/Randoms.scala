package com.kafkata.traffic.construction

import scala.util.Random

object Randoms {

  private val random = Random

  def pickRandomFrom[T](vs: Seq[T]): T = {
    val pick = random.nextInt(vs.length)
    vs(pick)
  }

  def pickRandomBetween(lower: Int, upper: Int): Int = {
    random.between(lower, upper)
  }

}
