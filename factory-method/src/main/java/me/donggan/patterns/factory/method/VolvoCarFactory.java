package me.donggan.patterns.factory.method;

/**
 * Date: 2019/10/6 Time: 11:51 AM
 *
 * @author Gan Dong
 */
public class VolvoCarFactory implements CarFactory {

  @Override
  public Car create() {
    return new VolvoCar();
  }
}
