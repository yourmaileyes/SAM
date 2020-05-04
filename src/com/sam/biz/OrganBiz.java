package com.sam.biz;


import com.sam.entity.Activity;
import com.sam.entity.Student;

import java.util.List;

public interface OrganBiz {
    List<Student> getStudnets(int activityId);
    List<Activity> getMyActiities(int organId);
}
