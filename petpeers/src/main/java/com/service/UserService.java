package com.service;



import com.model.User;

public interface UserService {

	public abstract User addUser(User user);

	public abstract User updateUser(User user);

	public abstract User listUser(User user);

	public abstract User getUserByID(User user);

	public abstract User removeUser();

	public abstract User findByUserName();

	public abstract User buyPet();

	public abstract User getMyPets();

}
