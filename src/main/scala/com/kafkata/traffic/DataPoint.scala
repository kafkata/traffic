package com.kafkata.traffic

import com.kafkata.traffic.car.Car

case class DataPoint(c: Car, p: Position) {
	override def toString: String = s"${c.id},${p.x},${p.y}"
}
