package info.donggan.patterns.factory;

import info.donggan.patterns.factory.model.BmwCar;
import info.donggan.patterns.factory.model.Car;
import info.donggan.patterns.factory.model.CarType;
import info.donggan.patterns.factory.model.TeslaCar;
import info.donggan.patterns.factory.model.VolvoCar;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Date: 2018/12/12 Time: 11:05 PM
 *
 * @author Gan Dong
 */

public class CarFactoryWithReflectionDemo {

  public static class CarFactoryWithReflection {

    private Map<CarType, Class<? extends Car>> registeredCarTypes = new ConcurrentHashMap<>();

    private static CarFactoryWithReflection INSTANCE;

    private CarFactoryWithReflection() {
    }

    public static CarFactoryWithReflection instance() {
      if (INSTANCE == null) {
        INSTANCE = new CarFactoryWithReflection();
      }
      return INSTANCE;
    }

    public void registerCar(CarType type, Class<? extends Car> carClass) {
      this.registeredCarTypes.put(type, carClass);
    }

    public Car createCar(CarType type) {
      if (type == null) {
        throw new IllegalArgumentException("type cannot be null");
      }
      Class<? extends Car> carClass = registeredCarTypes.get(type);
      if (carClass == null) {
        throw new RuntimeException("Car type not registered: " + type);
      }
      try {
        Constructor<? extends Car> carConstructor = carClass
            .getDeclaredConstructor();
        return carConstructor.newInstance();
      } catch (Exception e) {
        throw new RuntimeException(
            "Car of type " + type + " cannot be instantiated", e);
      }
    }

    public static void main(String[] args) {

      CarFactoryWithReflection.instance()
          .registerCar(CarType.BMW, BmwCar.class);
      CarFactoryWithReflection.instance()
          .registerCar(CarType.VOLVO, VolvoCar.class);
      CarFactoryWithReflection.instance()
          .registerCar(CarType.TESLA, TeslaCar.class);

      Car car1 = CarFactoryWithReflection.instance().createCar(CarType.BMW);
      car1.drive();

      Car car2 = CarFactoryWithReflection.instance().createCar(CarType.VOLVO);
      car2.drive();

      Car car3 = CarFactoryWithReflection.instance().createCar(CarType.TESLA);
      car3.drive();
    }

  }

}
