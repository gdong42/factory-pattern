package info.donggan.patterns.factory;

import static org.assertj.core.api.Assertions.assertThat;

import info.donggan.patterns.factory.CarFactoryWithoutReflectionDemo.CarFactoryWithoutReflection;
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
