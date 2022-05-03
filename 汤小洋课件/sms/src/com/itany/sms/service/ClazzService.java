package com.itany.sms.service;

import java.util.List;

import com.itany.sms.entity.Clazz;
import com.itany.sms.exception.ClazzException;

public interface ClazzService {
	// 1.查询所有班级
	public abstract List<Clazz> findAll();

	// 2.根据班级号查询班级
	public abstract Clazz findById(int id);

	// 3.添加班级
	public abstract void add(String name);
	
	// 删除班级
	public abstract void removeById(int id) throws ClazzException;
}
