package cn.zzu.dao;


import cn.zzu.entity.SchoolInfo;

public interface SchoolInfoDao {


    SchoolInfo getSchoolInfoBySchoolId(Integer schoolId);
}