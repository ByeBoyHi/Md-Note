package com.itany.sms.service;

import java.util.List;

import com.itany.sms.entity.Student;
import com.itany.sms.exception.StudentNotFoundException;
import com.itany.sms.exception.UsernameExistException;

public interface StudentService {

	// 1.查找所有学生
	public abstract List<Student> findAll();

	// 2.根据学号查询学生
	public abstract Student findById(int id);

	// 3.根据姓名和年龄范围查询学生
	public abstract List<Student> findByCondition(String name, int minAge,
			int maxAge);

	// 4.添加学生
	public abstract void add(Student stu) throws UsernameExistException;

	// 5.修改学生
	public abstract void modify(Student stu);

	// 6.根据学号删除学生
	public abstract void removeById(int id);

	// 调换学生所在班级
	public abstract void swap(String name1,String name2) throws StudentNotFoundException;
	
	
	
	
	
}
