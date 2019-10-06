package me.donggan.patterns.factory.method;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Date: 2018/12/13 Time: 10:54 PM
 *
 * @author Gan Dong
 */
public class SimpleCarFactoryTest {

  @Test
  public void testCreateCarWithBmwType() {
    assertThat(new BmwCarFactory().create()).isInstanceOf(BmwCar.class);
  }

  @Test
  public void testCreateCarWithVolvoType() {
    assertThat(new VolvoCarFactory().create()).isInstanceOf(VolvoCar.class);
  }

  @Test
  public void testCreateCarWithTeslaType() {
    assertThat(new TeslaCarFactory().create()).isInstanceOf(TeslaCar.class);
  }

}
