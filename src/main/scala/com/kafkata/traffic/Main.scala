package com.kafkata.traffic

import com.kafkata.traffic.car.Car
import com.typesafe.scalalogging.LazyLogging

object Main extends LazyLogging {

  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis()

    val cars = 0.to(Cars.numOfCars).map(Car.construct)

    Cars.write(cars)

    DataPoints.write(cars)

    logger.info(s"Runtime: ${(System.currentTimeMillis() - startTime) / 1000} seconds")
  }

}



