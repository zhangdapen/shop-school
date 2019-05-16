package cn.zzu.controller.SysManager;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.execption.MyExecption;
import cn.zzu.service.manager.impl.PermissionInfoServiceImpl;
import cn.zzu.util.JsonUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 申请管理
 *
 * @author silence
 * @create 2019-04-29-12:02
 */
@Controller
@RequestMapping(value = "sys/permission/")
public class PermissionController {
    Logger logger = (Logger) LoggerFactory.getLogger(PermissionController.class);
    @Autowired
    private PermissionInfoServiceImpl permissionInfoService;

    /**
     * 获取审核列表
     * @param params
     * @return
     * @throws MyExecption
     */
    @RequestMapping(value="getlist",method = RequestMethod.POST)
    @ResponseBody
    public String getlist(@RequestBody Map<String,Object> params)throws MyExecption {
        logger.debug("前台传来的数据"+params);
        int  applicaType = Integer.parseInt(params.get("applicaType").toString());
        int  applicaState = Integer.parseInt(params.get("applicaState").toString());
        List<PermissionInfo> list = permissionInfoService.getPermissionInfoList(params);
        return JsonUtils.object2json(list);
    }

    /**
     * 审核
     * @param params
     * @return
     * @throws MyExecption
     */
    @RequestMapping(value="check",method = RequestMethod.POST)
    @ResponseBody
    public String check(@RequestBody Map<String,Object> params)throws MyExecption {
        logger.debug("前台传来的数据"+params);
        Long  permissionId = Long.parseLong(params.get("permissionId").toString());
        int  applicaState = Integer.parseInt(params.get("applicaState").toString());
        permissionInfoService.checkPermission(permissionId,applicaState);
        return JsonUtils.object2json("");
    }

}
