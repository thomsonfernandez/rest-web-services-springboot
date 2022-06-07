package com.springboot.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.webservices.restfulwebservices.beans.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();

	private static int userCount = 0;

	static {
		users.add(new User(1, "Thomson", "971525384125", "thomsonferna@gmail.com", new Date()));
		userCount++;
		users.add(new User(2, "Jeffy", "971589714058", "thomsonferna@gmail.com", new Date()));
		userCount++;
		users.add(new User(3, "Johaan", "97150684125", "thomsonferna@gmail.com", new Date()));
		userCount++;
	}

	public List<User> retrieveAll(){
		return users;
	}

	public User findOne(int id) {
		for(User user : users) {
			if(user.getUserId() == id) {
				return user;
			}
		}
		return null;
	}

	public User createUser(User user) {
		user.setUserId(++userCount);
		users.add(user);
		return user;
	}

}
