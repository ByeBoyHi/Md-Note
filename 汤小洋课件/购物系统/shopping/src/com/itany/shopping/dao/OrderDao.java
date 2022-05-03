package com.itany.shopping.dao;

import java.util.List;

import com.itany.shopping.entity.Order;

public interface OrderDao {
	
	/**
	 * 
	 * 插入订单
	 * @param order
	 */
	public void insert(Order order);
	
	/**
	 * 根据用户id查询订单
	 * <功能描述>
	 * @param userId
	 * @return
	 */
	public List<Order> selectByUserId(int userId);
	
	/**
	 * 根据订单id查询订单
	 * @param id
	 * @return
	 */
	public Order selectById(int id,int userId);
}
