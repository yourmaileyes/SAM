package com.sam.biz.impl;


import com.sam.biz.OrganBiz;
import com.sam.entity.*;
import com.sam.mapper.ActivityMapper;
import com.sam.mapper.OrganMapper;
import com.sam.mapper.SignMapper;
import com.sam.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "OrganBiz")
public class OrganBizImpl implements OrganBiz {
    @Autowired
    SignMapper signMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    OrganMapper organMapper;
    @Override
    public List<Student> getStudnets(int activityId) {
        SignExample signExample = new SignExample();
        signExample.createCriteria().andActivityidEqualTo(activityId);
        List<Sign> signs = signMapper.selectByExample(signExample);
        List<Student> students = new ArrayList<>();
        for (Sign sign:signs){
            Student student = studentMapper.selectByPrimaryKey(sign.getStudentid());
            students.add(student);
        }
        return students;
    }

    @Override
    public List<Activity> getMyActiities(int organId) {
        ActivityExample activityExample = new ActivityExample();
        activityExample.createCriteria().andLableEqualTo(String.valueOf(organId));
        return activityMapper.selectByExample(activityExample);
    }

    @Override
    public void changepasswordOrgan(Organ organ) {
        organMapper.updateByPrimaryKeySelective(organ);
    }

    @Override
    public void deleteSign(int studentId, int activityId) {
        SignExample signExample = new SignExample();
        signExample.createCriteria().andActivityidEqualTo(activityId).andStudentidEqualTo(studentId);
        signMapper.deleteByExample(signExample);
    }
}
