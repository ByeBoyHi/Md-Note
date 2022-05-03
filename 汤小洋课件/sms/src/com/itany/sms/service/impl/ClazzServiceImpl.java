package com.itany.sms.service.impl;

import java.util.List;

import com.itany.sms.dao.ClazzDao;
import com.itany.sms.dao.StudentDao;
import com.itany.sms.entity.Clazz;
import com.itany.sms.entity.Student;
import com.itany.sms.exception.ClazzException;
import com.itany.sms.factory.ObjectFactory;
import com.itany.sms.service.ClazzService;

public class ClazzServiceImpl implements ClazzService {
	
	ClazzDao clazzDao=(ClazzDao) ObjectFactory.getObject("clazzDao");
	StudentDao studentDao=(StudentDao) ObjectFactory.getObject("studentDao");

	@Override
	public List<Clazz> findAll() {
		return clazzDao.selectAll();
	}

	@Override
	public Clazz findById(int id) {
		return clazzDao.selectById(id);
	}

	@Override
	public void add(String name) {
		clazzDao.insert(name);
	}

	@Override
	public void removeById(int id) throws ClazzException {
		List<Student> list = studentDao.selectByCid(id);
		if(!list.isEmpty()){
			throw new ClazzException("该班级不能被删除，班级中存在学生");
		}
		clazzDao.deleteById(id);
	}

}
