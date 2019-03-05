package cn.zzu.dao;

import cn.zzu.entity.SchoolInfo;

public interface SchoolInfoMapper {
    int deleteByPrimaryKey(Integer schoolId);

    int insert(SchoolInfo record);

    int insertSelective(SchoolInfo record);

    SchoolInfo selectByPrimaryKey(Integer schoolId);

    int updateByPrimaryKeySelective(SchoolInfo record);

    int updateByPrimaryKey(SchoolInfo record);
}