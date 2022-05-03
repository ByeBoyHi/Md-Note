package com.itany.shopping.service.impl;

import java.util.List;

import com.itany.shopping.dao.ProductDao;
import com.itany.shopping.entity.Product;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.ProductService;
import com.itany.shopping.vo.PageResult;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao=(ProductDao) ObjectFactory.getObject("productDao");

	@Override
	public List<Product> findAll() {
		return productDao.selectAll();
	}

	@Override
	public PageResult<Product> findByPage(int pageNo, int pageSize) {
		// 总数据条数
		int count = productDao.selectCount();
		// 当前页的数据
		List<Product> products = productDao.selectByPage(pageNo, pageSize);
		
		PageResult<Product> pageResult = new PageResult<Product>(count, products, pageNo, pageSize);
		return pageResult;
	}

	@Override
	public Product findById(int id) {
		return productDao.selectById(id);
	}

}
