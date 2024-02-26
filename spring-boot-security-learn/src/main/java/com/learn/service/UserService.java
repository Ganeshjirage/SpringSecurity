package com.learn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.model.User;

@Service
public class UserService {

	List<User> list = new ArrayList<User>();

	public UserService() {
		list.add(new User("Ganesh", "ganesh", "Ganesh@gmail.com"));
		list.add(new User("Mininath", "mininath", "Mininath@gmail.com"));

	}

	// Get all Users
	public List<User> getAllUsers() {
		return this.list;
	}

	// Get single User
	public User getUser(String userName) {
		return this.list.stream().filter((user) -> user.getUserName().equals(userName)).findAny().orElse(null);
	}

	// Add User
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}
