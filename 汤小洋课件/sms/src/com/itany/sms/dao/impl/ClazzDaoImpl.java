package com.itany.sms.dao.impl;

import java.util.List;

import com.itany.sms.dao.ClazzDao;
import com.itany.sms.entity.Clazz;
import com.itany.sms.mapper.ClazzMapper;
import com.itany.sms.util.JdbcTemplate;
import com.itany.sms.util.RowMapper;


public class ClazzDaoImpl implements ClazzDao {
	
	JdbcTemplate<Clazz> template=new JdbcTemplate<Clazz>();
	RowMapper<Clazz> rm=new ClazzMapper();
	

	//1.查询所有班级
	@Override
	public List<Clazz> selectAll(){
		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	id,name ")
			.append(" from ")
			.append(" 	t_class ")
			.toString();
		return template.query(sql, rm);
	}
	
	//2.根据班级号查询班级
	@Override
	public Clazz selectById(int id){
		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	id,name ")
			.append(" from ")
			.append(" 	t_class ")
			.append(" where ")
			.append(" 	id=? ")
			.toString();
		return template.queryForObject(sql, rm, id);
	}
	
	
	//3.添加班级
	@Override
	public void insert(String name){
		String sql=new StringBuffer()
			.append(" insert into ")
			.append(" 	t_class ")
			.append(" 		(name) ")
			.append(" values ")
			.append(" 		(?) ")
			.toString();
		template.update(sql, name);
	}

	@Override
	public void deleteById(int id) {
		String sql=new StringBuffer()
			.append(" delete from")
			.append(" 	t_class ")
			.append(" where ")
			.append(" 	id=? ")
			.toString();
		template.update(sql, id);
	}
	
}
