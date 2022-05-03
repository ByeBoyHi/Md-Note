package com.itany.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itany.jdbc.util.RowMapper;
import com.itany.shopping.entity.Order;
import com.itany.shopping.entity.User;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs) throws SQLException {
		Order order = new Order();
		order.setId(rs.getInt("id"));
		User user = new User();
		user.setId(rs.getInt("user_id"));
		order.setUser(user);
		order.setNo(rs.getString("no"));
		order.setPrice(rs.getDouble("price"));
		order.setCreateDate(rs.getTimestamp("createdate"));
		return order;
	}

}
