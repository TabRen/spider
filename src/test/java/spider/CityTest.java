package spider;

import org.junit.Test;
import spider.utils.SpiderMap;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * CityTest
 * Created by tab.ren on 2018/4/26.
 */
public class CityTest {

  @Test
  public void getCityTest() throws IOException {
    Province province = new Province();
    SpiderMap provinceMap = province.getProvince();
    City city = new City();
    city.getCity(provinceMap, "河北省");
  }

}