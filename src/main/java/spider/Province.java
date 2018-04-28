package spider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import spider.utils.SpiderMap;

import java.io.IOException;

/**
 * 爬取省一级的数据
 * Created by tab.ren on 2018/4/26.
 */
public class Province {

  public SpiderMap getProvince() throws IOException {
    SpiderMap provinceMap = new SpiderMap();
    final String url = StaticValue.baseUrl + "index.html";
    //区划名称
    String provinceName;
    //区划代码
    String provinceCode;
    //链接
    String provinceHref;
    Connection connection = Jsoup.connect(url).maxBodySize(0);
    Document document = connection.get();
    Elements elements = document.getElementsByClass("provincetr");
    for (Element element : elements) {
      for (Element children : element.children()) {
        provinceName = children.text();
        provinceHref = children.getElementsByTag("a").attr("href");
        //链接去掉".html"为区划代码
        provinceCode = provinceHref.substring(0, provinceHref.lastIndexOf("."));
        provinceMap.setCodeMap(provinceCode, provinceName, provinceHref);
      }
    }
    return provinceMap;
  }

}
