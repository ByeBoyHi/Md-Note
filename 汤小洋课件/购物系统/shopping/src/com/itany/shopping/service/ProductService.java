package com.itany.shopping.service;

import java.util.List;

import com.itany.shopping.entity.Product;
import com.itany.shopping.vo.PageResult;

public interface ProductService {
	
	public List<Product> findAll();
	
	public PageResult<Product> findByPage(int pageNo,int pageSize);

	public Product findById(int id);
}
