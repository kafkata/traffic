package com.kafkata.traffic

import scala.util.Random

case class Position(x: Int, y: Int) {
	def nextPosition(): Position = {
		Position(x + 1, y - 1)
	}
}

object Position {
	val r = new Random()

	def random(): Position = {
		Position(r.nextInt(1000), r.nextInt(1000))
	}
}
