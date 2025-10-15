package com.comrade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comrade.dao.UserDao;
import com.comrade.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;

	@Override
	public void saveUser(User user) {
		userdao.saveUser(user);
	}

	@Override
	public boolean validateUser(User user) {
		return userdao.validateUser(user);
	}

	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);
	}
}
