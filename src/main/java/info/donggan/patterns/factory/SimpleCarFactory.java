package info.donggan.patterns.factory;

import info.donggan.patterns.factory.model.BmwCar;
import info.donggan.patterns.factory.model.Car;
import info.donggan.patterns.factory.model.CarType;
import info.donggan.patterns.factory.model.TeslaCar;
import info.donggan.patterns.factory.model.VolvoCar;

/**
 * Date: 2018/12/12 Time: 11:05 PM
 *
 * @author Gan Dong
 */
public class SimpleCarFactory {

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
