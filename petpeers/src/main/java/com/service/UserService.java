package com.service;

import com.model.User;

public interface UserService {
 
	public User addUser(User user);
	public User updateUser(User user);
	public User listUser(User user);
	public User getUserByID(User user);
	public User removeUser();
	public User findByUserName();
	public User buyPet();
	public User getMyPets();
	
	
	
	
}
