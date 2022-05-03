package com.itany.shopping.service.proxy;

import java.util.List;

import com.itany.jdbc.exception.DataAccessException;
import com.itany.jdbc.transaction.TransactionManager;
import com.itany.shopping.entity.Product;
import com.itany.shopping.exception.ServiceException;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.ProductService;
import com.itany.shopping.vo.PageResult;

public class ProductServiceProxy implements ProductService {
	
	private TransactionManager tx=(TransactionManager) ObjectFactory.getObject("tx");
	private ProductService productService=(ProductService) ObjectFactory.getObject("productService");
	
	@Override
	public List<Product> findAll() {
		
		List<Product> list;
		try {
			tx.beginTransaction();
			list = productService.findAll();
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return list;
	}

	@Override
	public PageResult<Product> findByPage(int pageNo, int pageSize) {
		PageResult<Product> pageResult;
		try {
			tx.beginTransaction();
			pageResult = productService.findByPage(pageNo, pageSize);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return pageResult;
	}

	@Override
	public Product findById(int id) {
		Product product = null;
		try {
			tx.beginTransaction();
			product = productService.findById(id);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return product;
	}

}
