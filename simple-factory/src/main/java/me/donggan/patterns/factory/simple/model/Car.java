package me.donggan.patterns.factory.simple.model;

/**
 * Date: 2018/12/12 Time: 10:56 PM
 *
 * @author Gan Dong
 */
public interface Car {

  void drive();

  // only required by CarFactoryWithoutReflectionDemo.
  // A variation of "Factory Method"
  Car create();

}
