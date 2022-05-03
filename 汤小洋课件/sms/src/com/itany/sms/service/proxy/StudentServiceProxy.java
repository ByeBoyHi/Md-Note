package com.itany.sms.service.proxy;

import java.sql.SQLException;
import java.util.List;

import com.itany.sms.entity.Student;
import com.itany.sms.exception.DataAccessException;
import com.itany.sms.exception.ServiceException;
import com.itany.sms.exception.StudentNotFoundException;
import com.itany.sms.exception.UsernameExistException;
import com.itany.sms.factory.ObjectFactory;
import com.itany.sms.service.StudentService;
import com.itany.sms.transaction.TransactionManager;
import com.itany.sms.util.JdbcUtil;

public class StudentServiceProxy implements StudentService {
	
	StudentService studentService=(StudentService) ObjectFactory.getObject("studentService");
	TransactionManager tx = (TransactionManager) ObjectFactory.getObject("tx");

	@Override
	public List<Student> findAll() {
		List<Student> list;
		try {
			tx.beginTransaction();
			list = studentService.findAll();
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return list;
	}

	@Override
	public Student findById(int id) {
		Student student;
		try {
			tx.beginTransaction();
			student = studentService.findById(id);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return student;
	}

	@Override
	public List<Student> findByCondition(String name, int minAge, int maxAge) {
		List<Student> list;
		try {
			tx.beginTransaction();
			list = studentService.findByCondition(name, minAge, maxAge);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return list;
	}

	@Override
	public void add(Student stu) throws UsernameExistException {
		try {
			tx.beginTransaction();
			studentService.add(stu);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		} catch (UsernameExistException e) {
			throw e;
		}
	}

	@Override
	public void modify(Student stu) {
		try {
			tx.beginTransaction();
			studentService.modify(stu);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
	}

	@Override
	public void removeById(int id) {
		try {
			tx.beginTransaction();
			studentService.removeById(id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
	}

	@Override
	public void swap(String name1, String name2) throws StudentNotFoundException {
		try {
			tx.beginTransaction();
			studentService.swap(name1, name2);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常",e);
		} catch (StudentNotFoundException e) {
			throw e;
		}
	}

}
