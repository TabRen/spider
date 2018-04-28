package spider;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * CountyTest
 * Created by tab.ren on 2018/4/26.
 */
public class CountyTest {

  @Test
  public void getCountyTest() throws IOException {
    Province province = new Province();
    City city = new City();
    County county = new County();
    county.getCounty(city.getCity(province.getProvince(), "北京市"), "市辖区");
  }

}