package com.sam.biz.impl;

import com.sam.biz.MainBiz;
import com.sam.entity.*;
import com.sam.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    SignMapper signMapper;
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

    @Override
    public Activity activity(int id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> getComments(int activityId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andActivityidEqualTo(activityId);
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public boolean isSelect(int studentId, int activityId) {
        SignExample signExample = new SignExample();
        signExample.createCriteria().andActivityidEqualTo(activityId).andStudentidEqualTo(studentId);
        return !signMapper.selectByExample(signExample).isEmpty();
    }

    @Override
    public void insertComment(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void insertSign(int userid, int activityid) {
        Sign sign = new Sign();
        sign.setActivityid(activityid);
        sign.setStudentid(userid);
        signMapper.insert(sign);
    }

    @Override
    public void deleteSign(int userid, int activityid) {
        SignExample signExample = new SignExample();
        signExample.createCriteria().andStudentidEqualTo(userid).andActivityidEqualTo(activityid);
        signMapper.deleteByExample(signExample);
    }

}
