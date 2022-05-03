package com.itany.sms.service.proxy;

import java.util.List;

import javax.sql.rowset.spi.TransactionalWriter;

import com.itany.sms.entity.Clazz;
import com.itany.sms.exception.ClazzException;
import com.itany.sms.exception.DataAccessException;
import com.itany.sms.exception.ServiceException;
import com.itany.sms.factory.ObjectFactory;
import com.itany.sms.service.ClazzService;
import com.itany.sms.transaction.TransactionManager;

public class ClazzServiceProxy implements ClazzService {

	TransactionManager tx = (TransactionManager) ObjectFactory.getObject("tx");
	ClazzService clazzService = (ClazzService) ObjectFactory
			.getObject("clazzService");

	@Override
	public List<Clazz> findAll() {
		List<Clazz> list;
		try {
			tx.beginTransaction();
			list = clazzService.findAll();
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return list;
	}

	@Override
	public Clazz findById(int id) {
		Clazz clazz;
		try {
			tx.beginTransaction();
			clazz = clazzService.findById(id);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
		return clazz;
	}

	@Override
	public void add(String name) {
		try {
			tx.beginTransaction();
			clazzService.add(name);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
	}

	@Override
	public void removeById(int id) throws ClazzException  {
		try {
			tx.beginTransaction();
			clazzService.removeById(id);
			tx.commit();
		} catch (ClazzException e) {
			throw e;
		}catch(DataAccessException e){
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
	}

}
