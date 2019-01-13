package info.donggan.patterns.factory.model;

/**
 * Date: 2018/12/12 Time: 10:56 PM
 *
 * @author Gan Dong
 */
public interface Car {

  void drive();

  // only required by CarFactoryWithoutReflectionDemo
  Car create();

}
