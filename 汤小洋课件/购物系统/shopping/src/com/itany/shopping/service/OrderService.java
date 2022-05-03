package com.itany.shopping.service;

import java.util.List;

import com.itany.shopping.entity.Order;

public interface OrderService {
	
	public void add(Order order);
	
	public List<Order> findByUserId(int userId);
	
	public Order findById(int id,int userId);
	
}
