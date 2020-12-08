package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service
public class SecurityServiceImpl implements SecurityService {


	@Autowired
	private UserDao userDao;
	
	@Override
	public String authenticateUser(User user) {
		
		return userDao.authenticateUser(user);
	}

}
