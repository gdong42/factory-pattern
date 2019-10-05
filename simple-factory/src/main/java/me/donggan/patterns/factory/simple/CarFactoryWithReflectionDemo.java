package me.donggan.patterns.factory.simple;

import me.donggan.patterns.factory.simple.model.BmwCar;
import me.donggan.patterns.factory.simple.model.Car;
import me.donggan.patterns.factory.simple.model.CarType;
import me.donggan.patterns.factory.simple.model.TeslaCar;
import me.donggan.patterns.factory.simple.model.VolvoCar;
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

    // for testing purpose
    void unregisterCars() {
      this.registeredCarTypes.clear();
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
