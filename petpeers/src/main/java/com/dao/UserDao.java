package com.dao;

import com.model.User;
import com.service.SecurityService;

public interface UserDao extends SecurityService{
	public User addUser(User user);
	public User updateUser(User user);
	public User listUser(User user);
	public User getUserByID(User user);
	public User removeUser();
	public User findByUserName();
	public User buyPet();
	public User getMyPets();
	public String authenticateUser();


}
