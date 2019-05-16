package cn.zzu.service.manager;


public interface PermissionHandler {


    /**
     * 审核申请
     * @return
     */
    void checkPermission(Long id,Integer applicaState);
    void afterCheck(Integer applicaId, Integer applicaState);

}
