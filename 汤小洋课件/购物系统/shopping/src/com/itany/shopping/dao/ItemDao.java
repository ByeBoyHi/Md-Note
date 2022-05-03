package com.itany.shopping.dao;

import java.util.List;

import com.itany.shopping.entity.Item;

public interface ItemDao {
	
	/**
	 * 
	 * 插入订单明细
	 * @param item
	 */
	public void insert(Item item);
	
	/**
	 * 
	 * 根据订单编号查询订单明细
	 * @param orderId
	 * @return
	 */
	public List<Item> selectByOrderId(int orderId,int userId);
}
