package cn.zzu.dao;


import cn.zzu.entity.Coll;

public interface CollDao {


    /**
     * 新增收藏
     * @param coll
     * @return
     */
    int setColl(Coll coll);


    /**
     * 更细收藏信息
     * @param id
     * @return
     */
    int updateColl(Integer id);

}