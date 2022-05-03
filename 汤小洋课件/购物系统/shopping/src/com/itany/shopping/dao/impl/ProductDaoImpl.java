package com.itany.shopping.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.itany.jdbc.core.JdbcTemplate;
import com.itany.jdbc.util.RowMapper;
import com.itany.shopping.dao.ProductDao;
import com.itany.shopping.entity.Product;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.mapper.ProductMapper;

public class ProductDaoImpl implements ProductDao {

	private JdbcTemplate<Product> jt=(JdbcTemplate<Product>) ObjectFactory.getObject("jt");
	private RowMapper<Product> rm=new ProductMapper();
	
	@Override
	public List<Product> selectAll() {
		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	id,name,price ")
			.append(" from ")
			.append(" 	t_product ")
			.toString();
		return jt.query(sql, rm);
	}

	@Override
	public List<Product> selectByPage(int pageNo, int pageSize) {
		String sql=new StringBuffer()
		.append(" select ")
		.append(" 	id,name,price ")
		.append(" from ")
		.append(" 	t_product ")
		.append(" limit ")
		.append(" 	?,? ")
		.toString();
		return jt.query(sql, rm, (pageNo-1)*pageSize, pageSize);
	}

	@Override
	public int selectCount() {
		String sql=new StringBuffer()
		.append(" select ")
		.append(" 	count(id) ")
		.append(" from ")
		.append(" 	t_product ")
		.toString();
		Object obj = jt.queryForObject(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				return rs.getInt(1);
			}
		});
		return (int)obj;
	}

	@Override
	public Product selectById(int id) {
		String sql=new StringBuffer()
		.append(" select ")
		.append(" 	id,name,price ")
		.append(" from ")
		.append(" 	t_product ")
		.append(" where ")
		.append(" 	id=? ")
		.toString();
		return jt.queryForObject(sql, rm, id);
	}

}
