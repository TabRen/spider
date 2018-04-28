package spider.utils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * 工具类
 * Created by tab.ren on 2018/4/26.
 */
public class SpiderUtil {

  /**
   * 解析elements并返回Map
   */
  public SpiderMap getMapFromElements(Document document, String className, String prefix) {
    Elements elements = document.getElementsByClass(className);
    SpiderMap spiderMap = new SpiderMap();
    //区划码
    String childrenCode;
    //区划名称
    String childrenName;
    //链接
    String childrenHref;
    try {
      for (Element element : elements) {
        Elements childrens = new Elements();
        //village一级的数据没有链接
        if ("villagetr".equals(element.className())) {
          childrens = element.getElementsByTag("td");
        } else {
          childrens = element.getElementsByTag("a");
        }
        if (0 == childrens.size()) {
          continue;
        }
        //保存区划代码
        childrenCode = childrens.first().text();
        //保存区划名称
        childrenName = childrens.last().text();
        //保存链接
        childrenHref = childrens.last().attr("href");
        spiderMap.setCodeMap(childrenCode, childrenName, prefix + childrenHref);
      }
    } catch (Exception e) {
      System.out.println("SpiderUtil occur getMapFromElements exception: " + e);
      return null;
    }
    return spiderMap;
  }

}
