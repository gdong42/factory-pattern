package me.donggan.patterns.factory.method;

/**
 * Date: 2018/12/12 Time: 10:57 PM
 *
 * @author Gan Dong
 */
public class TeslaCar implements Car {

  @Override
  public void drive() {
    System.out.println("Calling TeslaCar::drive() method.");
  }

}
