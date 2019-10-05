package me.donggan.patterns.factory.simple;

import static org.assertj.core.api.Assertions.assertThat;

import me.donggan.patterns.factory.simple.SimpleCarFactoryDemo.SimpleCarFactory;
import me.donggan.patterns.factory.simple.model.BmwCar;
import me.donggan.patterns.factory.simple.model.CarType;
import me.donggan.patterns.factory.simple.model.TeslaCar;
import me.donggan.patterns.factory.simple.model.VolvoCar;
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
