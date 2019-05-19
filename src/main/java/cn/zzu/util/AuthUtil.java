package cn.zzu.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * http请求工具类
 *
 * @author silence
 * @create 2019-05-17-12:57
 */
public class AuthUtil {

    public static final String APPID="wx68167cd37899001c";
    public static final String APPSECRET="74cce7ffd1ab5c9f761afd0c65d6b1ff";
//    public static final String APPID="wxf8d840d60e95f8ac";
//    public static final String APPSECRET="6ad8acbedaa8de97252b65c1c26e7fb9";
    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject=null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity != null){
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject=JSONObject.fromObject(result);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }
}
