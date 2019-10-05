package me.donggan.patterns.factory.simple;

import static org.assertj.core.api.Assertions.assertThat;

import me.donggan.patterns.factory.simple.CarFactoryWithoutReflectionDemo.CarFactoryWithoutReflection;
import me.donggan.patterns.factory.simple.model.BmwCar;
import me.donggan.patterns.factory.simple.model.CarType;
import me.donggan.patterns.factory.simple.model.TeslaCar;
import me.donggan.patterns.factory.simple.model.VolvoCar;
import org.junit.Test;

/**
 * Date: 2019/1/9 Time: 10:04 PM
 *
 * @author Gan Dong
 */
public class CarFactoryWithoutReflectionTest {

  @Test
  public void testCreateCarWithBmwType() {
    assertThat(CarFactoryWithoutReflection.instance().createCar(CarType.BMW)).isInstanceOf(BmwCar.class);
  }

  @Test
  public void testCreateCarWithVolvoType() {
    assertThat(CarFactoryWithoutReflection.instance().createCar(CarType.VOLVO)).isInstanceOf(VolvoCar.class);
  }

  @Test
  public void testCreateCarWithTeslaType() {
    assertThat(CarFactoryWithoutReflection.instance().createCar(CarType.TESLA)).isInstanceOf(TeslaCar.class);
  }

}
