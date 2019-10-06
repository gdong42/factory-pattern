package me.donggan.patterns.factory.method;

/**
 * Date: 2019/10/6 Time: 11:42 AM
 *
 * @author Gan Dong
 */
public class FactoryMethodDemo {

  public static void main(String[] args) {

    CarFactory carFactory1 = new BmwCarFactory();
    Car car1 = carFactory1.create();
    car1.drive();

    CarFactory carFactory2 = new TeslaCarFactory();
    Car car2 = carFactory2.create();
    car2.drive();

    CarFactory carFactory3 = new VolvoCarFactory();
    Car car3 = carFactory3.create();
    car3.drive();
  }

}
