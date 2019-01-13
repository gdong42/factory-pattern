package info.donggan.patterns.factory;

import info.donggan.patterns.factory.model.Car;
import info.donggan.patterns.factory.model.CarType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Date: 2018/12/12 Time: 11:05 PM
 *
 * @author Gan Dong
 */

public class CarFactoryWithoutReflectionDemo {

  public static class CarFactoryWithoutReflection {

    private Map<CarType, Car> registeredCars = new ConcurrentHashMap<>();

    private static CarFactoryWithoutReflection INSTANCE;

    private CarFactoryWithoutReflection() {
    }

    public static CarFactoryWithoutReflection instance() {
      if (INSTANCE == null) {
        INSTANCE = new CarFactoryWithoutReflection();
      }
      return INSTANCE;
    }

    public void registerCar(CarType type, Car car) {
      this.registeredCars.put(type, car);
    }

    public Car createCar(CarType type) {
      if (type == null) {
        throw new IllegalArgumentException("type cannot be null");
      }
      Car car = registeredCars.get(type);
      if (car == null) {
        throw new RuntimeException("Car type not registered: " + type);
      }
      return car.create();
    }

    // make sure car type is registered to the factory before creating cars
    static {
      try {
        Class.forName("info.donggan.patterns.factory.model.BmwCar");
        Class.forName("info.donggan.patterns.factory.model.VolvoCar");
        Class.forName("info.donggan.patterns.factory.model.TeslaCar");
      } catch (ClassNotFoundException cnfe) {
        cnfe.printStackTrace();
      }
    }

    public static void main(String[] args) {

      Car car1 = CarFactoryWithoutReflection.instance().createCar(CarType.BMW);
      car1.drive();

      Car car2 = CarFactoryWithoutReflection.instance().createCar(CarType.VOLVO);
      car2.drive();

      Car car3 = CarFactoryWithoutReflection.instance().createCar(CarType.TESLA);
      car3.drive();
    }

  }

}
