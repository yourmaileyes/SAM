package com.sam.biz;

import com.sam.entity.*;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
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

    void updateActivity(HttpServletRequest request) throws ParseException;

    List<Activity> getActivities();

    List<Student> getStudents();

    Student getStudent(int id);

    void deleteStudent(int id);

    void updateStudent(Student student);

    List<Organ> getOrgan();

    Organ getOrgan(int id);

    void deleteOrgan(int id);

    void updateOrgan(Organ organ);

}
