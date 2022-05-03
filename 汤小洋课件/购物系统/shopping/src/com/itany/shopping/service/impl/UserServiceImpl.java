package com.itany.shopping.service.impl;

import com.itany.shopping.constant.UserConstant;
import com.itany.shopping.dao.UserDao;
import com.itany.shopping.entity.User;
import com.itany.shopping.exception.UserDisabledException;
import com.itany.shopping.exception.UserNotFoundException;
import com.itany.shopping.exception.UsernameExistException;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.UserService;
import com.itany.shopping.util.EncryptUtil;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao=(UserDao) ObjectFactory.getObject("userDao");
	
	@Override
	public void regist(User user) throws UsernameExistException {
		User u = userDao.selectByUsername(user.getUsername());
		if(u!=null){
			throw new UsernameExistException("该用户名已注册");
		}
		
		// 状态默认为启用
		user.setStatus(UserConstant.USER_STATUS_ENABLE);
		// 对密码进行加密处理
		user.setPassword(EncryptUtil.md5(user.getPassword()));
		userDao.insert(user);
	}

	@Override
	public User login(User user) throws UserNotFoundException, UserDisabledException {
		// 对密码进行加密处理
		user.setPassword(EncryptUtil.md5(user.getPassword()));
				
		User u = userDao.selectByUsernameAndPassword(user);
		if(u==null){
			throw new UserNotFoundException("用户名或密码错误");
		}
		if(u.getStatus()==UserConstant.USER_STATUS_DISABLE){
			throw new UserDisabledException("用户被禁用");
		}
		return u;
	}

	@Override
	public void modifyPassword(int id, String newPassword) {
		userDao.updatePassword(id,EncryptUtil.md5(newPassword));
	}

}
