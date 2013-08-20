package com.lok.dao;

import java.util.List;

import com.lok.model.User;

public interface UserDao {

	public abstract User save(User user);
	
	public abstract void delete(User user);
	
	public abstract User update(User user);
	
	public abstract User getUserById(long userId);
	
	public abstract User getLogInUser(User user);
	
	public abstract long getUserCount();
	
	public abstract List<User> getAllUsers();
	
	public abstract void userLoggedout(long userId);
	
	public abstract List<User> getLoggedUsers(long userId);
	
}
