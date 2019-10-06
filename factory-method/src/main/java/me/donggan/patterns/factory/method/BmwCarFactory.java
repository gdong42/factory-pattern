package me.donggan.patterns.factory.method;

/**
 * Date: 2019/10/6 Time: 11:49 AM
 *
 * @author Gan Dong
 */
public class BmwCarFactory implements CarFactory {

  @Override
  public Car create() {
    return new BmwCar();
  }
}
