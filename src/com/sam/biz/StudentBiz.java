package com.sam.biz;

import com.sam.entity.Activity;
import com.sam.entity.Student;
import com.sam.entity.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentBiz {
    void changePassword(Student student);
    List<Activity> getMyActivity(int studentId);

}
