package com.itany.shopping.dao.impl;

import com.itany.jdbc.core.JdbcTemplate;
import com.itany.jdbc.util.RowMapper;
import com.itany.shopping.dao.UserDao;
import com.itany.shopping.entity.User;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.mapper.UserMapper;

public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate<User> jt=(JdbcTemplate<User>) ObjectFactory.getObject("jt");
	private RowMapper<User> rm=new UserMapper();
	
	@Override
	public void insert(User user) {
		String sql=new StringBuffer()
			.append(" insert into ")
			.append(" 	t_user ")
			.append(" 		(username,password,phone,address,status) ")
			.append(" values ")
			.append(" 		(?,?,?,?,?) ")
			.toString();
		jt.update(sql, user.getUsername(),user.getPassword(),user.getPhone(),user.getAddress(),user.getStatus());
	}

	@Override
	public User selectByUsername(String username) {
		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	id,username,password,phone,address,status ")
			.append(" from ")
			.append(" 	t_user ")
			.append(" where ")
			.append(" 	username=? ")
			.toString();
		return jt.queryForObject(sql, rm, username);
	}

	@Override
	public User selectByUsernameAndPassword(User user) {
		String sql=new StringBuffer()
		.append(" select ")
		.append(" 	id,username,password,phone,address,status ")
		.append(" from ")
		.append(" 	t_user ")
		.append(" where ")
		.append(" 	username=? and password=?")
		.toString();
		return jt.queryForObject(sql, rm, user.getUsername(),user.getPassword());
	}

	@Override
	public void updatePassword(int id, String newPassword) {
		String sql=new StringBuffer()
			.append(" update ")
			.append(" 	t_user ")
			.append(" set ")
			.append(" 	password=? ")
			.append(" where ")
			.append(" 	id=? ")
			.toString();
		jt.update(sql, newPassword,id);
	}

}
