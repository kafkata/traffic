package com.kafkata.traffic

import com.sksamuel.avro4s.AvroSchema
import org.apache.avro.Schema
import play.api.libs.json.{Format, Json}

case class DataPoint(carId: String, position: Position, timestamp: Long)

object DataPoint {

	implicit val dataPointFormat: Format[DataPoint] = Json.format[DataPoint]
	val schema: Schema = AvroSchema[DataPoint]

}
