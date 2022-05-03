package com.itany.shopping.dao.impl;

import java.util.List;

import com.itany.jdbc.core.JdbcTemplate;
import com.itany.jdbc.util.RowMapper;
import com.itany.shopping.dao.ItemDao;
import com.itany.shopping.entity.Item;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.mapper.ItemMapper;

public class ItemDaoImpl implements ItemDao {
	
	private JdbcTemplate<Item> jt=(JdbcTemplate<Item>) ObjectFactory.getObject("jt");
	private RowMapper<Item> rm=new ItemMapper();
	
	@Override
	public void insert(Item item) {
		String sql=new StringBuffer()
			.append(" insert into ")
			.append(" 	t_item ")
			.append(" 		(product_id,num,price,order_id) ")
			.append(" values ")
			.append(" 		(?,?,?,?) ")
			.toString();
		jt.update(sql, item.getProduct().getId(),item.getNum(),item.getPrice(),item.getOrder().getId());
	}

	@Override
	public List<Item> selectByOrderId(int orderId,int userId) {
		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	i.id 'i.id',i.num 'i.num',i.price 'i.price',p.id 'p.id',p.name 'p.name',p.price 'p.price' ")
			.append(" from ")
			.append(" 		t_item i ")
			.append(" 	left join ")
			.append(" 		t_product p")
			.append(" 			on i.product_id=p.id ")
			.append(" 	left join ")
			.append(" 		t_order o")
			.append(" 			on i.order_id=o.id ")
			.append(" where ")
			.append(" 	i.order_id=? and o.user_id=?")
			.toString();
		return jt.query(sql, rm, orderId,userId);
	}

}
