package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		return userDao.addUser(user);

	}

	@Override
	public User updateUser(User user) {
		
		return userDao.updateUser(user);
	}

	@Override
	public User listUser(User user) {
		
		return userDao.listUser(user);
	}

	@Override
	public User getUserByID(User user) {
		
		return userDao.getUserByID(user);
	}

	@Override
	public User removeUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User buyPet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getMyPets() {
		// TODO Auto-generated method stub
		return null;
	}

}
