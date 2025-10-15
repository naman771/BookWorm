package com.comrade.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.comrade.entity.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{

	@Override
	public void saveUser(User user) {
		persist(user);
		
	}

	@Override
	public boolean validateUser(User user) {
		Query query = getSession().createQuery("From User where userName=:userName");
		query.setParameter("userName", user.getUserName());
		User user1 = (User) query.uniqueResult();
		System.out.println("user="+user+" "+user.getUserName()+"pass"+user.getPassword());
		System.out.println("user1="+user1+" "+user1.getUserName()+"pass"+user1.getPassword());
		
		if (user1.getPassword().equals(user.getPassword()))
			return true;
		return false;
	}

	@Override
	public void updateUser(User user) {
		getSession().update(user);
	}
}
