package com.itany.shopping.service.proxy;

import com.itany.jdbc.exception.DataAccessException;
import com.itany.jdbc.transaction.TransactionManager;
import com.itany.shopping.entity.User;
import com.itany.shopping.exception.ServiceException;
import com.itany.shopping.exception.UserDisabledException;
import com.itany.shopping.exception.UserNotFoundException;
import com.itany.shopping.exception.UsernameExistException;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.UserService;

public class UserServiceProxy implements UserService {
	
	private TransactionManager tx=(TransactionManager) ObjectFactory.getObject("tx");
	private UserService userService=(UserService) ObjectFactory.getObject("userService");

	@Override
	public void regist(User user) throws UsernameExistException {
		try {
			tx.beginTransaction();
			userService.regist(user);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
	}

	@Override
	public User login(User user) throws UserNotFoundException, UserDisabledException {
		User u = null;
		try {
			tx.beginTransaction();
			u = userService.login(user);
			tx.commit();
		} catch (UserNotFoundException e) {
			throw e;
		} catch (UserDisabledException e) {
			throw e;
		} catch(DataAccessException e){
			throw new ServiceException("服务异常", e);
		}
		return u;
	}

	@Override
	public void modifyPassword(int id, String newPassword) {
		try {
			tx.beginTransaction();
			userService.modifyPassword(id, newPassword);
			tx.commit();
		} catch (DataAccessException e) {
			tx.rollback();
			throw new ServiceException("服务异常", e);
		}
	}

}
