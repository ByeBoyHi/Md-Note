package com.itany.sms.service.impl;

import java.util.List;

import com.itany.sms.dao.StudentDao;
import com.itany.sms.entity.Student;
import com.itany.sms.exception.StudentNotFoundException;
import com.itany.sms.exception.UsernameExistException;
import com.itany.sms.factory.ObjectFactory;
import com.itany.sms.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	StudentDao studentDao=(StudentDao) ObjectFactory.getObject("studentDao");

	@Override
	public List<Student> findAll() {
		return studentDao.selectAll();
	}

	@Override
	public Student findById(int id) {
		return studentDao.selectById(id);
	}

	@Override
	public List<Student> findByCondition(String name, int minAge, int maxAge) {
		return studentDao.selectByCondition(name, minAge, maxAge);
	}

	@Override
	public void add(Student stu) throws UsernameExistException {
		Student student = studentDao.selectByName(stu.getName());
		if(student!=null){
			throw new UsernameExistException("用户名已存在");
		}
		studentDao.insert(stu);
	}

	@Override
	public void modify(Student stu) {
		studentDao.update(stu);
	}

	@Override
	public void removeById(int id) {
		studentDao.deleteById(id);
	}

	@Override
	public void swap(String name1, String name2) throws StudentNotFoundException {
		Student stu1 = studentDao.selectByName(name1);
		Student stu2 = studentDao.selectByName(name2);
		if(stu1==null){
			throw new StudentNotFoundException("未找到学生："+name1);
		}
		if(stu2==null){
			throw new StudentNotFoundException("未找到学生："+name2);
		}
		studentDao.updateClazzId(stu1.getId(), stu2.getClazz().getId());
		int a=5/0;
		studentDao.updateClazzId(stu2.getId(), stu1.getClazz().getId());
	}

}
