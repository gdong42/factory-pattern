package info.donggan.patterns.factory.model;

/**
 * Date: 2018/12/12 Time: 10:57 PM
 *
 * @author Gan Dong
 */
public class BmwCar implements Car {

  @Override
  public void drive() {
    System.out.println("Calling BmwCar::drive() method.");
  }
}
