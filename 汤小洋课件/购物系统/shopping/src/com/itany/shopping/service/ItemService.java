package com.itany.shopping.service;

import java.util.List;

import com.itany.shopping.entity.Item;

public interface ItemService {

	public List<Item> findByOrderId(int orderId,int userId);
}
