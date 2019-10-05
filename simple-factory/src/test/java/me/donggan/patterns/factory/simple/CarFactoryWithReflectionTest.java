package me.donggan.patterns.factory.simple;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import me.donggan.patterns.factory.simple.CarFactoryWithReflectionDemo.CarFactoryWithReflection;
import me.donggan.patterns.factory.simple.model.BmwCar;
import me.donggan.patterns.factory.simple.model.CarType;
import me.donggan.patterns.factory.simple.model.TeslaCar;
import me.donggan.patterns.factory.simple.model.VolvoCar;
import org.junit.Before;
import org.junit.Test;

/**
 * Date: 2019/1/9 Time: 10:04 PM
 *
 * @author Gan Dong
 */
public class CarFactoryWithReflectionTest {

  @Before
  public void setUp() {
    CarFactoryWithReflection.instance().unregisterCars();
  }

  @Test
  public void testCreateCarWithBmwType() {
    CarFactoryWithReflection.instance().registerCar(CarType.BMW, BmwCar.class);
    assertThat(CarFactoryWithReflection.instance().createCar(CarType.BMW)).isInstanceOf(BmwCar.class);
  }

  @Test
  public void testCreateCarWithVolvoType() {
    CarFactoryWithReflection.instance().registerCar(CarType.VOLVO, VolvoCar.class);
    assertThat(CarFactoryWithReflection.instance().createCar(CarType.VOLVO)).isInstanceOf(VolvoCar.class);
  }

  @Test
  public void testCreateCarWithTeslaType() {
    CarFactoryWithReflection.instance().registerCar(CarType.TESLA, TeslaCar.class);
    assertThat(CarFactoryWithReflection.instance().createCar(CarType.TESLA)).isInstanceOf(TeslaCar.class);
  }


  @Test
  public void testCreateCarFailIfNotRegistered() {

    assertThatExceptionOfType(RuntimeException.class).isThrownBy(() ->
            CarFactoryWithReflection.instance().createCar(CarType.BMW)
        ).withMessageContaining("not registered")
        .withMessageContaining("BMW");

    assertThatExceptionOfType(RuntimeException.class).isThrownBy(() ->
        CarFactoryWithReflection.instance().createCar(CarType.VOLVO)
    ).withMessageContaining("not registered")
        .withMessageContaining("VOLVO");


    assertThatExceptionOfType(RuntimeException.class).isThrownBy(() ->
        CarFactoryWithReflection.instance().createCar(CarType.TESLA)
    ).withMessageContaining("not registered")
        .withMessageContaining("TESLA");
  }

}
