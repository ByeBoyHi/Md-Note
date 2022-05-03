package com.itany.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itany.jdbc.util.RowMapper;
import com.itany.shopping.entity.Item;
import com.itany.shopping.entity.Product;

public class ItemMapper implements RowMapper<Item> {

	@Override
	public Item mapRow(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("p.id"));
		product.setName(rs.getString("p.name"));
		product.setPrice(rs.getDouble("p.price"));

		Item item = new Item();
		item.setId(rs.getInt("i.id"));
		item.setProduct(product);
		item.setNum(rs.getInt("i.num"));
		item.setPrice(rs.getDouble("i.price"));
		
		return item;
	}

}
