package com.comrade.dao;

import com.comrade.entity.User;

public interface UserDao {
	void saveUser(User user);

	boolean validateUser(User user);

	void updateUser(User user);
}
