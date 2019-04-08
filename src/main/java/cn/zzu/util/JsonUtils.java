package cn.zzu.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * json工具类
 *
 * @author silence
 * @create 2019-04-06-19:21
 */
public class JsonUtils {


    /**
     * map转json
     * @param map
     * @return
     */
  public static String map2json(Map<String,Object> map){

      return JSONObject.toJSONString(map);
  }
}
