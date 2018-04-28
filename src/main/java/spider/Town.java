package spider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import spider.utils.SpiderMap;
import spider.utils.SpiderUtil;

import java.io.IOException;
import java.util.Map;

/**
 * 爬取Town一级的数据
 * Created by tab.ren on 2018/4/27.
 */
public class Town {

  public SpiderMap getTownMap(SpiderMap countyMap, String countyName) throws IOException {
    String prefix = "";
    String index = "";
    for (Map<String, String> map : countyMap.getNameMaps()) {
      if (countyName.equals(map.get("name"))) {
        index = map.get("href");
        prefix = index.substring(index.indexOf("/") + 1).substring(0, 2);
        break;
      }
    }
    final String url = StaticValue.baseUrl + prefix + "/" + index;
    Connection connection = Jsoup.connect(url).maxBodySize(0);
    Document document = connection.get();
    SpiderUtil spiderUtil = new SpiderUtil();
    return spiderUtil.getMapFromElements(document, "towntr", prefix);
  }
}
