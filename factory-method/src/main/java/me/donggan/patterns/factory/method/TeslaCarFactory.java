package me.donggan.patterns.factory.method;

/**
 * Date: 2019/10/6 Time: 11:50 AM
 *
 * @author Gan Dong
 */
public class TeslaCarFactory implements CarFactory {

  @Override
  public Car create() {
    return new TeslaCar();
  }
}
