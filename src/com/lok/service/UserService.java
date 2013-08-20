package com.lok.service;

import java.util.List;

import com.lok.model.User;

public interface UserService {

	public abstract User saveUser(User user);
	
	public abstract void deleteUser(User user);
	
	public abstract User updateUser(User user);
	
	public abstract User getUserById(long userId);
	
	public abstract User getLogInUser(User user);
	
	public abstract long getUserCount();
	
	public abstract List<User> getAllUsers();
	
	public abstract void userLoggedout(long userId);
	
	public abstract List<User> getLoggedUsers(long userId);
}
