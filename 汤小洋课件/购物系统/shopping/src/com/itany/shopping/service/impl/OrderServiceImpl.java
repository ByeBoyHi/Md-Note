package com.itany.shopping.service.impl;

import java.util.List;

import com.itany.shopping.dao.ItemDao;
import com.itany.shopping.dao.OrderDao;
import com.itany.shopping.entity.Item;
import com.itany.shopping.entity.Order;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao=(OrderDao) ObjectFactory.getObject("orderDao");
	private ItemDao itemDao=(ItemDao) ObjectFactory.getObject("itemDao");
	
	@Override
	public void add(Order order) {
		// 向订单表中插入数据
		orderDao.insert(order);
		// 向订单明细表中插入数据
		for(Item item:order.getItems()){
			item.setOrder(order); // 设置item订单明细 所属的Order订单
			itemDao.insert(item);
		}
	}

	@Override
	public List<Order> findByUserId(int userId) {
		return orderDao.selectByUserId(userId);
	}

	@Override
	public Order findById(int id,int userId) {
		return orderDao.selectById(id,userId);
	}

}
