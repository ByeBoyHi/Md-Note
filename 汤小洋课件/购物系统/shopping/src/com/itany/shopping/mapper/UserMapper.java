package com.itany.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itany.jdbc.util.RowMapper;
import com.itany.shopping.entity.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setPhone(rs.getString("phone"));
		user.setAddress(rs.getString("address"));
		user.setStatus(rs.getInt("status"));
		return user;
	}

}
