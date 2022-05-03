package com.itany.shopping.service.proxy;

import java.util.List;

import com.itany.jdbc.exception.DataAccessException;
import com.itany.jdbc.transaction.TransactionManager;
import com.itany.shopping.entity.Order;
import com.itany.shopping.exception.ServiceException;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.OrderService;

public class OrderServiceProxy implements OrderService {

	private TransactionManager tx = (TransactionManager) ObjectFactory
			.getObject("tx");
	private OrderService orderService = (OrderService) ObjectFactory
			.getObject("orderService");

	@Override
	public void add(Order order) {
		try {
			tx.beginTransaction();
			orderService.add(order);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
	}

	@Override
	public List<Order> findByUserId(int userId) {
		List<Order> list = null;
		try {
			tx.beginTransaction();
			list = orderService.findByUserId(userId);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return list;
	}

	@Override
	public Order findById(int id,int userId) {
		Order order = null;
		try {
			tx.beginTransaction();
			order = orderService.findById(id,userId);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return order;
	}

}
