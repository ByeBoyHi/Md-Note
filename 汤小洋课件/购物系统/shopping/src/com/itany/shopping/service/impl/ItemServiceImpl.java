package com.itany.shopping.service.impl;

import java.util.List;

import com.itany.shopping.dao.ItemDao;
import com.itany.shopping.entity.Item;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.ItemService;

public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao=(ItemDao) ObjectFactory.getObject("itemDao");
	
	@Override
	public List<Item> findByOrderId(int orderId,int userId) {
		return itemDao.selectByOrderId(orderId,userId);
	}

}
