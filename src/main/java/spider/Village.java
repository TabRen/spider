package spider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import spider.utils.SpiderMap;
import spider.utils.SpiderUtil;

import java.io.IOException;
import java.util.Map;

/**
 * 获取Village一级的信息
 * Created by tab.ren on 2018/4/28.
 */
public class Village {

  public SpiderMap getVillage(SpiderMap townMap, String townName) throws IOException {
    String prefix = "";
    String index = "";
    for (Map<String, String> map : townMap.getNameMaps()) {
      if (townName.equals(map.get("name"))) {
        index = map.get("href");
        index = index.substring(index.indexOf("/") + 1);
        String code = index.substring(index.indexOf("/") + 1).substring(0, 6);
        String provinceCode = code.substring(0, 2);
        String cityCode = code.substring(2, 4);
        String townCode = code.substring(4, 6);
        prefix = provinceCode + "/" + cityCode + "/" + townCode;
        break;
      }
    }
    final String url = StaticValue.baseUrl + prefix + "/" + index;
    Connection connection = Jsoup.connect(url).maxBodySize(0);
    Document document = connection.get();
    SpiderUtil spiderUtil = new SpiderUtil();
    return spiderUtil.getMapFromElements(document, "villagetr", "");
  }

}
