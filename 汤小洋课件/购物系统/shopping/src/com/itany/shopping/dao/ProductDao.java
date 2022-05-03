package com.itany.shopping.dao;

import java.util.List;

import com.itany.shopping.entity.Product;

public interface ProductDao {
	
	/**
	 * 查询所有商品
	 */
	public List<Product> selectAll();
	
	/**
	 * 分页查询商品
	 */
	public List<Product> selectByPage(int pageNo,int pageSize);
	
	/**
	 * 查询总商品数据
	 */
	public int selectCount();

	/**
	 * 根据id查询商品
	 */
	public Product selectById(int id);
}
