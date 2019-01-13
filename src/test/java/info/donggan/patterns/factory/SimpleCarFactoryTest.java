package info.donggan.patterns.factory;

import static org.assertj.core.api.Assertions.assertThat;

import info.donggan.patterns.factory.SimpleCarFactoryDemo.SimpleCarFactory;
import info.donggan.patterns.factory.model.BmwCar;
import info.donggan.patterns.factory.model.CarType;
import info.donggan.patterns.factory.model.TeslaCar;
import info.donggan.patterns.factory.model.VolvoCar;
import org.junit.Test;

/**
 * Date: 2018/12/13 Time: 10:54 PM
 *
 * @author Gan Dong
 */
public class SimpleCarFactoryTest {

  @Test
  public void testCreateCarWithBmwType() {
    assertThat(SimpleCarFactory.createCar(CarType.BMW)).isInstanceOf(BmwCar.class);
  }

  @Test
  public void testCreateCarWithVolvoType() {
    assertThat(SimpleCarFactory.createCar(CarType.VOLVO)).isInstanceOf(VolvoCar.class);
  }

  @Test
  public void testCreateCarWithTeslaType() {
    assertThat(SimpleCarFactory.createCar(CarType.TESLA)).isInstanceOf(TeslaCar.class);
  }

}
