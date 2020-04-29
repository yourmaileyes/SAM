package com.sam.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.biz.StudentBiz;
import com.sam.mapper.StudentMapper;

@Service(value="StudentBiz")
public class StudentBizImpl implements StudentBiz {
	@Autowired
	StudentMapper studentMapper;
}
