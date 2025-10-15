package com.comrade.service;

import com.comrade.entity.User;

public interface UserService {
	void saveUser(User user);

	boolean validateUser(User user);

	void updateUser(User user);
}
