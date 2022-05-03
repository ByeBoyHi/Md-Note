package com.itany.shopping.service;

import com.itany.shopping.entity.User;
import com.itany.shopping.exception.UserDisabledException;
import com.itany.shopping.exception.UserNotFoundException;
import com.itany.shopping.exception.UsernameExistException;

public interface UserService {
	
	public void regist(User user) throws UsernameExistException;

	public User login(User user) throws UserNotFoundException, UserDisabledException;

	public void modifyPassword(int id, String newPassword);
	
}
