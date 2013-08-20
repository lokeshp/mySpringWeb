package com.lok.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lok.model.User;

public class UserRowMapper implements RowMapper {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user= new User();
		while ( rs.next() ) { 
			user.setId(rs.getLong("Id"));
			user.setName(rs.getString("Name"));
			user.setUserName(rs.getString("UserName"));
			user.setPassword(rs.getString("Password"));
			user.setEmail(rs.getString("Email"));
			user.setLocation(rs.getString("Location"));
		}
		return user;
	}
}
