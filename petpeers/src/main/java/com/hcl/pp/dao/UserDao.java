package com.hcl.pp.dao;

import org.springframework.stereotype.Repository;

import com.hcl.pp.model.User;
import com.hcl.pp.service.SecurityService;

public interface UserDao{
	public abstract User addUser(User user);
	public abstract User updateUser(User user);
	public abstract User listUser(User user);
	public abstract User getUserByID(User user);
	public abstract User removeUser();
	public abstract User findByUserName(String username);
	public abstract User buyPet(User user);
	public abstract User getMyPets();
	public abstract boolean authenticateUser(String username, String userPassword);
	public abstract User authenticateUser1(int userid);
	User buyPet();
	
	


}
