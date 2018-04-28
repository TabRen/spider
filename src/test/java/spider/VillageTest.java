package spider;

import org.junit.Test;
import spider.utils.SpiderMap;

import java.io.IOException;

/**
 * VillageTest
 * Created by tab.ren on 2018/4/28.
 */
public class VillageTest {

  @Test
  public void getVillageTest() throws IOException {
    Province province = new Province();
    City city = new City();
    County county = new County();
    Town town = new Town();
    Village village = new Village();
    SpiderMap spiderMap = village.getVillage(
        town.getTownMap(county.getCounty(city.getCity(province.getProvince(), "河北省"), "秦皇岛市"),
            "山海关区"), "第一关镇");
    System.out.println(spiderMap.getCodeMap().toString());
  }

}