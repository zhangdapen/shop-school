package cn.zzu.constant;

/**
 * 系统管理
 * @author silence
 * @create 2019-04-29-12:02
 */
public class ManagerConstant {

    //权限审核 申请类别
    //学校管理员申请
    public static final Integer APPLICA_TYPE_ROOT_SCHOOL = 1;
    //商品发布
    public static final Integer APPLICA_TYPE_GOOD_INFO = 2;
    //帖子发布
    public static final Integer APPLICA_TYPE_NEEWS_INFO = 3;

    //权限审核 状态
    //待审核
    public static final Integer APPLICA_STATE_NEW = 0;
    //审核通过
    public static final Integer APPLICA_STATE_CHECKED_TRUE = 1;
    //审核不通过
    public static final Integer APPLICA_STATE_CHECKED_FALSE = 2;



}
