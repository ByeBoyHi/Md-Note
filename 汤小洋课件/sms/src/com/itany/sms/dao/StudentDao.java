package com.itany.sms.dao;

import java.util.List;

import com.itany.sms.entity.Student;

public interface StudentDao {

	// 1.查询所有学生
	public abstract List<Student> selectAll();

	// 2.根据学号查询学生
	public abstract Student selectById(int id);

	// 3.根据姓名和年龄范围查询学生
	public abstract List<Student> selectByCondition(String name, int minAge,
			int maxAge);

	// 4.添加学生
	public abstract void insert(Student stu);

	// 5.修改学生
	public abstract void update(Student stu);

	// 6.根据学号删除学生
	public abstract void deleteById(int id);
	
	// 修改学生所在班级
	public abstract void updateClazzId(int sid,int cid);
	
	// 根据姓名查询学生
	public abstract Student selectByName(String name);
	
	// 根据班级号查询学生
	public abstract List<Student> selectByCid(int id);

}