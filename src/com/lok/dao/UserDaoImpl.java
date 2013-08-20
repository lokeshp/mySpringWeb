package com.lok.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.lok.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public User save(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String insertSql = "insert into user (Name,UserName,Password,Email,Location,LoggedIn) values (?,?,?,?,?.?)";
		jdbcTemplate.update(insertSql, new Object[]{
				user.getName(),user.getUserName(),user.getPassword(),user.getEmail(),user.getLocation(),0
		});
		user.setId(this.getLogInUser(user).getId());
		return user;
	}

	@Override
	public void delete(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String deleteSql = "delete from user where Id = ?";
		jdbcTemplate.update(deleteSql, new Object[]{user.getId()});
	}

	@Override
	public User update(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String updateSql = "update user set Name=?, UserName=?, Password=?, Email=?, Location=? where Id = ?";
		jdbcTemplate.update(updateSql, new Object[]{
				user.getName(),user.getUserName(),user.getPassword(),user.getEmail(),user.getLocation(),user.getId()
		});
		return user;
	}
	
	@Override
	public User getLogInUser(User user){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String selectSql = "select * from user where UserName=? and Password = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectSql, new Object[]{ user.getUserName(),user.getPassword()});
		User loggedUser = this.setUsers(rowSet).get(0);
		if(loggedUser.getId() != 0){
			updateLogInfo(loggedUser.getId(),true);
			loggedUser.setLoggedIn(1);
		}
		return loggedUser;
	}
	
	@Override
	public User getUserById(long userId){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		User user = new User();
		String selectSql = "select * from user where Id=?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectSql, new Object[]{ userId});
		return this.setUsers(rowSet).get(0);
	}
	
	@Override
	public long getUserCount(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String selectSql = "select count(*) from user";
		return jdbcTemplate.queryForLong(selectSql);
	}
	
	@Override
	public List<User> getAllUsers(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String selectSql = "select * from user";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectSql);
		return this.setUsers(rowSet);
	}
	
	private List<User> setUsers(SqlRowSet rowSet){
		List<User> users = new ArrayList<User>();
		while(rowSet.next()){
			User user = new User();
			user.setId(rowSet.getLong("Id"));
			user.setName(rowSet.getString("Name"));
			user.setUserName(rowSet.getString("UserName"));
			user.setPassword(rowSet.getString("Password"));
			user.setEmail(rowSet.getString("Email"));
			user.setLocation(rowSet.getString("Location"));
			user.setLoggedIn(rowSet.getInt("LoggedIn"));			
			users.add(user);
		}
		if(users.size() == 0){
			users.add(new User());
		}
		return users;
	}

	private void updateLogInfo(long userId,boolean isLoggedIn){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String selectSql = "update user set LoggedIn = " + (isLoggedIn?1:0) +" where Id = "+userId;
		jdbcTemplate.update(selectSql);
	}

	@Override
	public void userLoggedout(long userId) {
		this.updateLogInfo(userId, false);
	}

	@Override
	public List<User> getLoggedUsers(long userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String selectSql = "select * from user where LoggedIn = 1 and Id != "+userId;
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectSql);
		return this.setUsers(rowSet);
	}
	
}
