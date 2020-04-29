package com.sam.biz.impl;

import com.sam.biz.MainBiz;
import com.sam.entity.*;
import com.sam.mapper.ActivityMapper;
import com.sam.mapper.AdminMapper;
import com.sam.mapper.OrganMapper;
import com.sam.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "MainBiz")
public class MainBizImpl implements MainBiz {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    OrganMapper organMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Override
    public Object longin(String username, String password, int type) {
        switch (type){
            case 1://学生登录
                StudentExample studentExample = new StudentExample();
                studentExample.createCriteria().andAccountEqualTo(username).andPasswordEqualTo(password);
                if (studentMapper.selectByExample(studentExample).isEmpty())
                    return null;
                else
                    return studentMapper.selectByExample(studentExample).get(0);
            case 2://组织者登录
                OrganExample organExample = new OrganExample();
                organExample.createCriteria().andAccountEqualTo(username).andPasswordEqualTo(password);
                if (organMapper.selectByExample(organExample).isEmpty())
                    return null;
                else
                    return organMapper.selectByExample(organExample).get(0);
            case 3://管理员登录
                AdminExample adminExample = new AdminExample();
                adminExample.createCriteria().andAccountEqualTo(username).andPasswordEqualTo(password);
                if (adminMapper.selectByExample(adminExample).isEmpty())
                    return null;
                else
                    return adminMapper.selectByExample(adminExample).get(0);
        }
        return null;
    }

    @Override
    public List<Activity> activities() {
        ActivityExample activityExample = new ActivityExample();
        activityExample.createCriteria().andStatusGreaterThanOrEqualTo(1);
        return activityMapper.selectByExample(activityExample);
    }
}
