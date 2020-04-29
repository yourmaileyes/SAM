package com.sam.biz.impl;

import com.sam.entity.Admin;
import com.sam.entity.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.biz.AdminBiz;
import com.sam.mapper.AdminMapper;

import java.util.List;

@Service(value="AdminBiz")
public class AdminBizImpl implements AdminBiz{
	@Autowired
	AdminMapper adminMapper;

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
}
