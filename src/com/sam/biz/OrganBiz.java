package com.sam.biz;


import com.sam.entity.Activity;
import com.sam.entity.Organ;
import com.sam.entity.Student;

import java.util.List;

public interface OrganBiz {
    List<Student> getStudnets(int activityId);
    List<Activity> getMyActiities(int organId);
    void changepasswordOrgan(Organ organ);
    void deleteSign(int studentId,int activityId);
}
