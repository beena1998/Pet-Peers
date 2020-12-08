package com.dao;

import org.springframework.stereotype.Repository;

import com.model.User;
import com.service.SecurityService;

public interface UserDao{
	public abstract User addUser(User user);
	public abstract User updateUser(User user);
	public abstract User listUser(User user);
	public abstract User getUserByID(User user);
	public abstract User removeUser();
	public abstract User findByUserName();
	public abstract User buyPet();
	public abstract User getMyPets();
	public abstract String authenticateUser(User user);
	


}
