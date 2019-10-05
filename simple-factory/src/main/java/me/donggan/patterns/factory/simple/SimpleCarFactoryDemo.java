package me.donggan.patterns.factory.simple;

import me.donggan.patterns.factory.simple.model.BmwCar;
import me.donggan.patterns.factory.simple.model.Car;
import me.donggan.patterns.factory.simple.model.CarType;
import me.donggan.patterns.factory.simple.model.TeslaCar;
import me.donggan.patterns.factory.simple.model.VolvoCar;

/**
 * Date: 2018/12/12 Time: 11:05 PM
 *
 * @author Gan Dong
 */
public class SimpleCarFactoryDemo {

  public static class SimpleCarFactory {

    public static Car createCar(CarType type) {
      if (type == null) {
        throw new IllegalArgumentException("type cannot be null");
      }
      if (type == CarType.BMW) {
        return new BmwCar();
      } else if (type == CarType.VOLVO) {
        return new VolvoCar();
      } else if (type == CarType.TESLA) {
        return new TeslaCar();
      } else {
        throw new IllegalArgumentException("Unknown car type: " + type);
      }
    }
  }

  public static void main(String[] args) {

    Car car1 = SimpleCarFactory.createCar(CarType.BMW);
    car1.drive();

    Car car2 = SimpleCarFactory.createCar(CarType.VOLVO);
    car2.drive();

    Car car3 = SimpleCarFactory.createCar(CarType.TESLA);
    car3.drive();
  }

}
