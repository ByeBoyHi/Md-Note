package com.itany.shopping.dao;

import com.itany.shopping.entity.User;

public interface UserDao {
	
	public void insert(User user);

	public User selectByUsername(String username);

	public User selectByUsernameAndPassword(User user);

	public void updatePassword(int id, String newPassword);
	
}
