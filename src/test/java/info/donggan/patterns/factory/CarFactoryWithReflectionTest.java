package info.donggan.patterns.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import info.donggan.patterns.factory.CarFactoryWithReflectionDemo.CarFactoryWithReflection;
import info.donggan.patterns.factory.model.BmwCar;
import info.donggan.patterns.factory.model.CarType;
import info.donggan.patterns.factory.model.TeslaCar;
import info.donggan.patterns.factory.model.VolvoCar;
import org.junit.Test;

/**
 * Date: 2019/1/9 Time: 10:04 PM
 *
 * @author Gan Dong
 */
public class CarFactoryWithReflectionTest {

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
