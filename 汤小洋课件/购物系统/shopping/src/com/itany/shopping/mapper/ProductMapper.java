package com.itany.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itany.jdbc.util.RowMapper;
import com.itany.shopping.entity.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		return product;
	}

}
