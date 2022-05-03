package com.itany.sms.dao;

import java.util.List;

import com.itany.sms.entity.Clazz;

public interface ClazzDao {

	//1.查询所有班级
	public abstract List<Clazz> selectAll();

	//2.根据班级号查询班级
	public abstract Clazz selectById(int id);

	//3.添加班级
	public abstract void insert(String name);

	// 删除班级
	public abstract void deleteById(int id);
}