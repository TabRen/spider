package spider.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * SpiderMap
 * Created by tab.ren on 2018/4/27.
 */
public class SpiderMap {

  private Map<String, Map<String, String>> codeMap = new HashMap<>();

  public void setCodeMap(String code, String name, String href) {
    Map<String, String> nameMap = new HashMap<>();
    nameMap.put("name", name);
    nameMap.put("href", href);
    this.codeMap.put(code, nameMap);
  }

  public Map getCodeMap() {
    return this.codeMap;
  }

  public Collection<Map<String, String>> getNameMaps() {
    return this.codeMap.values();

  }

}
