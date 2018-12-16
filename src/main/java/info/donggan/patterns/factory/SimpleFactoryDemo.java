package info.donggan.patterns.factory;

import info.donggan.patterns.factory.model.Car;
import info.donggan.patterns.factory.model.CarType;

/**
 * Date: 2018/12/12 Time: 10:54 PM
 *
 * @author Gan Dong
 */
public class SimpleFactoryDemo {

  public static void main(String[] args) {

    Car car1 = SimpleCarFactory.createCar(CarType.BMW);
    car1.drive();

    Car car2 = SimpleCarFactory.createCar(CarType.VOLVO);
    car2.drive();

    Car car3 = SimpleCarFactory.createCar(CarType.TESLA);
    car3.drive();
  }

}
