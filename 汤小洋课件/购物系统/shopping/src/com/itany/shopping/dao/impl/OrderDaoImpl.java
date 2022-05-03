package com.itany.shopping.dao.impl;

import java.util.List;

import com.itany.jdbc.core.JdbcTemplate;
import com.itany.jdbc.util.RowMapper;
import com.itany.shopping.dao.OrderDao;
import com.itany.shopping.entity.Order;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.mapper.OrderMapper;

public class OrderDaoImpl implements OrderDao {

	private JdbcTemplate<Order> jt=(JdbcTemplate<Order>) ObjectFactory.getObject("jt");
	private RowMapper<Order> rm=new OrderMapper();
	
	@Override
	public void insert(Order order) {
		String sql=new StringBuffer()
			.append(" insert into ")
			.append(" 	t_order ")
			.append(" 		(user_id,no,price,createdate) ")
			.append(" values ")
			.append(" 		(?,?,?,?) ")
			.toString();
		int id = jt.save(sql, order.getUser().getId(),order.getNo(),order.getPrice(),order.getCreateDate());
		order.setId(id);
	}

	@Override
	public List<Order> selectByUserId(int userId) {
		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	id,user_id,no,price,createdate ")
			.append(" from ")
			.append(" 	t_order ")
			.append(" where ")
			.append(" 	user_id=? ")
			.toString();
		return jt.query(sql, rm, userId);
	}

	@Override
	public Order selectById(int id,int userId) {
		String sql=new StringBuffer()
		.append(" select ")
		.append(" 	id,user_id,no,price,createdate ")
		.append(" from ")
		.append(" 	t_order ")
		.append(" where ")
		.append(" 	id=? and user_id=?")
		.toString();
		return jt.queryForObject(sql, rm, id,userId);
	}

}
