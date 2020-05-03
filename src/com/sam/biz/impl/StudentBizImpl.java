package com.sam.biz.impl;

import com.sam.entity.Activity;
import com.sam.entity.Sign;
import com.sam.entity.SignExample;
import com.sam.entity.Student;
import com.sam.mapper.ActivityMapper;
import com.sam.mapper.SignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.biz.StudentBiz;
import com.sam.mapper.StudentMapper;

import java.util.ArrayList;
import java.util.List;

@Service(value="StudentBiz")
public class StudentBizImpl implements StudentBiz {
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	ActivityMapper activityMapper;
	@Autowired
	SignMapper signMapper;

	@Override
	public void changePassword(Student student) {
		studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public List<Activity> getMyActivity(int studentId) {
		List<Activity> activities = new ArrayList<>();
		SignExample signExample = new SignExample();
		signExample.createCriteria().andStudentidEqualTo(studentId);
		List<Sign> signs = signMapper.selectByExample(signExample);
		for (Sign sign:signs){
			Activity activity = activityMapper.selectByPrimaryKey(sign.getActivityid());
			activities.add(activity);
		}
		if (activities.size()==0)
			return null;
		return activities;
	}
}
