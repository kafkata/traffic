package com.kafkata.traffic

import java.io.{BufferedWriter, File, FileOutputStream, OutputStreamWriter}
import java.util.zip.GZIPOutputStream

import com.kafkata.traffic.car.Car
import play.api.libs.json.Json

object Main {

  val numOfCars = 100000
  val resolutionSeconds = 1
  val numOfSteps = 600
  val logEveryXStep = 100
  val datasetPath = "output/dataset.json.gz"
  val carsPath = "output/cars.json.gz"

  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis()

    val cars = 0.to(numOfCars).map(Car.construct)

    writeCarsToFile(cars)

    val datasetWriter = createGzipFileWriter(datasetPath);

    0.to(numOfSteps).foreach { step =>
      if (step % logEveryXStep == 0) {
        println(s"Step: $step/$numOfSteps. ${computeRuntime(startTime, System.currentTimeMillis())} seconds")
      }

      cars.foreach { c =>
        val dp = DataPoint(c, Position.random())
        datasetWriter.write(Json.stringify(Json.toJson(dp)))
        datasetWriter.newLine()
      }
    }

    datasetWriter.close()

    println(s"Runtime: ${computeRuntime(startTime, System.currentTimeMillis())} seconds")
  }

  private def computeRuntime(startTime: Long, endTime: Long): Long = {
    (endTime - startTime) / 1000
  }

  private def writeCarsToFile(cars: IndexedSeq[Car]): Unit = {
    val path = carsPath
    val carsWriter = createGzipFileWriter(path);

    cars.foreach { c =>
      carsWriter.write(Json.stringify(Json.toJson(c)))
      carsWriter.newLine()
    }

    carsWriter.close()
  }

  private def createGzipFileWriter(path: String) = {
    val file = new File(path)
    file.createNewFile()
    new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(file))))
  }

}



