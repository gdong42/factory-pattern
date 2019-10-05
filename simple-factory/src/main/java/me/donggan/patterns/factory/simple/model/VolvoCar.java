package me.donggan.patterns.factory.simple.model;

import me.donggan.patterns.factory.simple.CarFactoryWithoutReflectionDemo.CarFactoryWithoutReflection;

/**
 * Date: 2018/12/12 Time: 10:57 PM
 *
 * @author Gan Dong
 */
public class VolvoCar implements Car {

  // only required by CarFactoryWithoutReflectionDemo
  static {
    CarFactoryWithoutReflection.instance()
        .registerCar(CarType.VOLVO, new VolvoCar());
  }

  @Override
  public void drive() {
    System.out.println("Calling VolvoCar::drive() method.");
  }

  // only required by CarFactoryWithoutReflectionDemo
  @Override
  public Car create() {
    return new VolvoCar();
  }
}
