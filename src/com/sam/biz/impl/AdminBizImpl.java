package com.sam.biz.impl;

import com.sam.entity.*;
import com.sam.mapper.ActivityMapper;
import com.sam.mapper.OrganMapper;
import com.sam.mapper.StudentMapper;
import com.sam.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.biz.AdminBiz;
import com.sam.mapper.AdminMapper;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Service(value="AdminBiz")
public class AdminBizImpl implements AdminBiz{
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	ActivityMapper activityMapper;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	OrganMapper organMapper;

	@Override
	public int countByExample(AdminExample example) {
		return adminMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(AdminExample example) {
		return adminMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return adminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Admin record) {
		return adminMapper.insert(record);
	}

	@Override
	public int insertSelective(Admin record) {
		return adminMapper.insertSelective(record);
	}

	@Override
	public List<Admin> selectByExample(AdminExample example) {
		return adminMapper.selectByExample(example);
	}

	@Override
	public Admin selectByPrimaryKey(Integer id) {
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Admin record, AdminExample example) {
		return adminMapper.updateByExampleSelective(record,example);
	}

	@Override
	public int updateByExample(Admin record, AdminExample example) {
		return adminMapper.updateByExample(record,example);
	}

	@Override
	public int updateByPrimaryKeySelective(Admin record) {
		return adminMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Admin record) {
		return adminMapper.updateByPrimaryKey(record);
	}

	@Override
	public void aplActivity(int activityId) {
		Activity activity = activityMapper.selectByPrimaryKey(activityId);
		activity.setStatus(1);
		activityMapper.updateByPrimaryKeySelective(activity);
	}

	@Override
	public void deleteActivity(int activityId) {
		activityMapper.deleteByPrimaryKey(activityId);
	}

	@Override
	public void updateActivity(HttpServletRequest request) throws ParseException {
		Activity activity = (Activity) UploadFile.uploadFile(request);
		assert activity != null;
		if (activity.getId()==null||activity.getId()==0){
			activityMapper.insertSelective(activity);
		}else {
			activityMapper.updateByPrimaryKeySelective(activity);
		}
	}

	@Override
	public List<Activity> getActivities() {
		return activityMapper.selectByExample(new ActivityExample());
	}

	@Override
	public List<Student> getStudents() {
		return studentMapper.selectByExample(new StudentExample());
	}

	@Override
	public Student getStudent(int id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteStudent(int id) {
		studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateStudent(Student student) {
		if (student.getId()==null||student.getId()==0)
			studentMapper.insertSelective(student);
		else
			studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public List<Organ> getOrgan() {
		return organMapper.selectByExample(new OrganExample());
	}

	@Override
	public Organ getOrgan(int id) {
		return organMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteOrgan(int id) {
		organMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateOrgan(Organ organ) {
		if (organ.getId()==null||organ.getId()==0)
			organMapper.insertSelective(organ);
		else
			organMapper.updateByPrimaryKeySelective(organ);
	}
}
