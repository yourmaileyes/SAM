package com.sam.biz;

import com.sam.entity.Activity;
import com.sam.entity.Admin;
import com.sam.entity.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminBiz {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    void aplActivity(int activityId);

    void deleteActivity(int activityId);

    void updateActivity(Activity activity);

}
