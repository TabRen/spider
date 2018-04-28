package spider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import spider.utils.SpiderMap;
import spider.utils.SpiderUtil;

import java.io.IOException;
import java.util.Map;

/**
 * 爬取城市一级的数据
 * Created by tab.ren on 2018/4/26.
 */
public class City {

  public SpiderMap getCity(SpiderMap province, String provinceName) throws IOException {
    String index = "";
    for (Map<String, String> map : province.getNameMaps()) {
      if (provinceName.equals(map.get("name"))) {
        index = map.get("href");
        break;
      }
    }
    final String url = StaticValue.baseUrl + index;
    Connection connection = Jsoup.connect(url).maxBodySize(0);
    Document document = connection.get();
    SpiderUtil spiderUtil = new SpiderUtil();
    return spiderUtil.getMapFromElements(document, "citytr", "");
  }

}
