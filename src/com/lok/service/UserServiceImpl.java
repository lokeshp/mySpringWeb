package com.lok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lok.dao.UserDao;
import com.lok.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.update(user);
	}

	@Override
	public User getUserById(long userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public User getLogInUser(User user) {
		return userDao.getLogInUser(user);
	}

	@Override
	public long getUserCount() {
		return userDao.getUserCount();
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void userLoggedout(long userId) {
		userDao.userLoggedout(userId);
	}

	@Override
	public List<User> getLoggedUsers(long userId) {
		return userDao.getLoggedUsers(userId);
	}

}
