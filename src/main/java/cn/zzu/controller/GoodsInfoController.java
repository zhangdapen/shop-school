package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.service.GoodsInfoService;
import cn.zzu.service.OrderInfoService;
import cn.zzu.util.JsonUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 商品
 *
 * @author silence
 * @create 2019-04-29-12:02
 */
@Controller
@RequestMapping(value = "goods")
public class GoodsInfoController {

    @Autowired
    private GoodsInfoService goodsInfoService;

    int msg=0;

    Logger logger = (Logger) LoggerFactory.getLogger(UserInfoController.class);

    @RequestMapping(value="/getGoods",method = RequestMethod.POST)
    @ResponseBody
    public String getGoodsInfo(@RequestBody Map<String,Object> params){
        logger.debug("获取所有商品信息前台传来的数据"+params);
        Map<String, Object> goodsInfo = goodsInfoService.getGoodsInfo();
        return JsonUtils.map2json(goodsInfo);
    }



    @RequestMapping(value="/digital",method = RequestMethod.POST)
    @ResponseBody
    public String getGoodsInfoBy(@RequestBody Map<String,Object> params){
        Map<String,Object> result = new HashMap<>();
        logger.debug("获取类别商品前台传来的数据"+params);
        if(params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        String ids = params.get("id").toString();
        Integer categoryId = Integer.valueOf(ids);
        Map<String, Object> goodsInfoByCategory = goodsInfoService.getGoodsInfoByCategory(categoryId);
        return JsonUtils.map2json(goodsInfoByCategory);
    }


    @RequestMapping(value="/getGoodsById",method = RequestMethod.POST)
    @ResponseBody
    public String getGoodsById(@RequestBody Map<String,Object> params){
        Map<String,Object> result = new HashMap<>();
        logger.debug("获取特定id商品前台传来的数据"+params);
        if(params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        String ids = params.get("goodsId").toString();
        Integer goodsId = Integer.valueOf(ids);
        Map<String, Object> goodsInfoByGoodsId = goodsInfoService.getGoodsInfoByGoodsId(goodsId);
        return JsonUtils.map2json(goodsInfoByGoodsId);
    }


    /**
     * 上传商品
     * @param file
     * @param fileDesc
     * @param goodsName
     * @param price
     * @param category
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/toupload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file,  @RequestParam("fileDesc") String fileDesc, @RequestParam("goodsName") String goodsName
            , @RequestParam("price") String price, @RequestParam("userId") String userId, @RequestParam("category") String category) throws IOException {
        logger.debug("======上传图片=====");
        //上传的路径
        String path = "http://59.110.213.231:8080/image/goods/";
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename=uuid+"_"+filename;
        //创建客户端对象
        Client client = Client.create();
        WebResource resource = client.resource(path + filename);
        //上传文件
        resource.put(file.getBytes());
        logger.debug("上传成功");
        //把名字写入数据库
        System.out.println("描述"+fileDesc);
        System.out.println("名称"+goodsName);
        System.out.println("价格"+price);
        System.out.println("类别"+category);
        System.out.println("用户id"+userId);
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsName(goodsName);
        goodsInfo.setGoodsPrice(Double.valueOf(price));
        goodsInfo.setCategoryId(Integer.valueOf(category));
        goodsInfo.setGoodsDes(fileDesc);
        goodsInfo.setUserId(Integer.valueOf(userId));
        goodsInfo.setGoodsImage(filename);
        goodsInfo.setSchoolId(1);
        goodsInfo.setGoodsState(0);
        goodsInfo.setGoodsType(0);
        goodsInfo.setCreateTime(new Date());
        msg = goodsInfoService.setInsertGoodsInfo(goodsInfo);
        System.out.println(msg);
        return "等待审核";
    }

    @RequestMapping(value="/up",method = RequestMethod.POST)
    @ResponseBody
    public String up(@RequestBody Map<String,Object> pa){
        Map<String,Object> result = new HashMap<>();
        result.put("msg",msg);
        return JsonUtils.map2json(result);
    }
}
