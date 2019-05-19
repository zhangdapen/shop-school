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

  public static String object2json(Object object){
      return JSONObject.toJSONString(object);
  }


    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GB2312
                String s = encode;
                return s; //是的话，返回“GB2312“，以下代码同理
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是ISO-8859-1
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是UTF-8
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GBK
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return ""; //如果都不是，说明输入的内容不属于常见的编码格式
    }
}
