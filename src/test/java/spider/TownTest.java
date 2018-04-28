package spider;

import org.junit.Test;

import java.io.IOException;

/**
 * TownTest
 * Created by tab.ren on 2018/4/27.
 */

public class TownTest {

  @Test
  public void getTownTese() throws IOException {
    Province province = new Province();
    City city = new City();
    County county = new County();
    Town town = new Town();
    town.getTownMap(county.getCounty(city.getCity(province.getProvince(), "河北省"), "秦皇岛市"), "北戴河区");
  }

}