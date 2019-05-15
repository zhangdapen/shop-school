package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.Coll;
import cn.zzu.service.CollService;
import cn.zzu.service.NewService;
import cn.zzu.util.JsonUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * 商品
 *
 * @author silence
 * @create 2019-04-29-12:02
 */
@Controller
@RequestMapping(value = "new")
public class NewsController {

    @Autowired
    private NewService newService;

    Logger logger = (Logger) LoggerFactory.getLogger(NewsController.class);

    @RequestMapping(value="/getNews",method = RequestMethod.POST)
    @ResponseBody
    public String setColl(@RequestBody Map<String,Object> params){
        logger.debug("获取收藏前台传来的数据"+params);
        Map<String, Object> news = newService.getNews();
        return JsonUtils.map2json(news);
    }

}
