package com.kafkata.traffic

case class DataPoint(c: Car, p: Position) {
	override def toString: String = s"${c.id},${p.x},${p.y}"
}
