package com.kafkata.traffic

import java.io.{File, FileInputStream, FileOutputStream}
import java.util.zip.{GZIPInputStream, GZIPOutputStream}

import com.kafkata.traffic.car.Car
import com.sksamuel.avro4s.{AvroInputStream, AvroOutputStream}
import com.typesafe.scalalogging.LazyLogging

object Cars extends LazyLogging {

  def main(args: Array[String]): Unit = {
    write(0.to(Cars.numOfCars).map(Car.construct))
    read()
  }

  val numOfCars = 100000
  val carsPath = "output/cars.avro.gz"

  def write(cars: IndexedSeq[Car]): Unit = {

    val carsFile = new File(carsPath)
    carsFile.createNewFile()

    val outputStream = AvroOutputStream
      .data[Car]
      .to(new GZIPOutputStream(new FileOutputStream(carsFile)))
      .build(Car.schema)

    cars.foreach { c =>
      outputStream.write(c)
    }

    outputStream.flush()
  }

  def read(): Unit = {

    val inputStream = AvroInputStream
      .data[Car]
      .from(new GZIPInputStream(new FileInputStream(new File(carsPath))))
      .build(Car.schema)

    val cars = inputStream.iterator.take(1000).toList
    inputStream.close()

    logger.info(cars.mkString("\n"))
  }

  }
