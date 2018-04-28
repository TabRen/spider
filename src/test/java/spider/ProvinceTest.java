package spider;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * ProvinceTest
 * Created by tab.ren on 2018/4/26.
 */
public class ProvinceTest {

  @Test
  public void getProvinceTest() throws IOException {
    Province province = new Province();
    province.getProvince();
  }
}