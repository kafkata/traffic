package com.kafkata.traffic

import java.io.{BufferedWriter, File, PrintWriter}

object Main {

	val numOfCars = 100000
	val resolutionSeconds = 1
  val numOfSteps = 600
	val logEveryXStep = 100
	val datasetPath = "output/dataset.csv"
	val carsPath = "output/cars.csv"

	def main(args: Array[String]): Unit = {
		val startTime = System.currentTimeMillis()

		val datasetFile = new File(datasetPath)
		datasetFile.createNewFile()

		val carsFile = new File(carsPath)
		carsFile.createNewFile()

		val cars = (0.to(numOfCars)).map(Car(_))

		val datasetWriter = new BufferedWriter(new PrintWriter(datasetFile))

		(0.to(numOfSteps)).foreach{ step =>
			if (step % logEveryXStep == 0) {
				println(s"Step: ${step}/${numOfSteps}")
			}

			cars.foreach{ c =>
				val dp = DataPoint(c, Position.random())

				datasetWriter.write(s"${dp.toString}\n")
			}
		}

		datasetWriter.close()

		val carsWriter = new BufferedWriter(new PrintWriter(carsFile))
		cars.foreach{ c => carsWriter.write(s"${c.toString}\n")}
		carsWriter.close()

		val endTime = System.currentTimeMillis()

		println(s"Runtime: ${(endTime - startTime) / 1000} seconds")
	}
}



