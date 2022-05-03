package com.itany.shopping.service.proxy;

import java.util.List;

import com.itany.jdbc.exception.DataAccessException;
import com.itany.jdbc.transaction.TransactionManager;
import com.itany.shopping.entity.Item;
import com.itany.shopping.exception.ServiceException;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.ItemService;

public class ItemServiceProxy implements ItemService {

	private TransactionManager tx = (TransactionManager) ObjectFactory
			.getObject("tx");
	private ItemService itemService = (ItemService) ObjectFactory
			.getObject("itemService");

	@Override
	public List<Item> findByOrderId(int orderId,int userId) {
		List<Item> list = null;
		try {
			tx.beginTransaction();
			list = itemService.findByOrderId(orderId,userId);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return list;
	}

}
