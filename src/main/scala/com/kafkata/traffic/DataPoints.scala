package com.kafkata.traffic

import java.io.{File, FileInputStream, FileOutputStream}
import java.util.zip.{GZIPInputStream, GZIPOutputStream}

import com.kafkata.traffic.Cars.numOfCars
import com.kafkata.traffic.car.Car
import com.sksamuel.avro4s.{AvroInputStream, AvroOutputStream}
import com.typesafe.scalalogging.LazyLogging

object DataPoints extends LazyLogging {

  def main(args: Array[String]): Unit = {
    write(0.to(numOfCars).map(Car.construct))
    read()
  }

  val resolutionSeconds = 1
  val numOfSteps = 600
  val logEveryXStep = 100
  val dataPointsPath = "output/dataset.avro.gz"

  def write(cars: Seq[Car]): Unit = {

    val startTime = System.currentTimeMillis()

    val dataPointsFile = new File(dataPointsPath)
    dataPointsFile.createNewFile()

    val os = AvroOutputStream
      .data[DataPoint]
      .to(new GZIPOutputStream(new FileOutputStream(dataPointsFile)))
      .build(DataPoint.schema)

    0.to(numOfSteps).foreach { step =>
      if (step % logEveryXStep == 0) {
        logger.info(s"Step: $step/$numOfSteps. ${(System.currentTimeMillis() - startTime) / 1000} seconds")
      }

      val timestamp = startTime + 1000

      cars.foreach { c =>
        val dp = DataPoint(c, Position.random(), timestamp)
        os.write(dp)
      }
    }

    os.close()
  }

  def read(): Unit = {

    val is = AvroInputStream
      .data[DataPoint]
      .from(new GZIPInputStream(new FileInputStream(new File(dataPointsPath))))
      .build(DataPoint.schema)

    val dataPoints = is.iterator.take(1000).toList
    is.close()

    logger.info(dataPoints.mkString("\n"))
  }

}
