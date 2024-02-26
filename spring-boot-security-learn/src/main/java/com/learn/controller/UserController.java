package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.User;
import com.learn.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// get all user
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return this.userService.getAllUsers();

	}

	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser() {
		return ResponseEntity.ok("Yes, I am Normal User");
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser() {
		return ResponseEntity.ok("Yes, I am Admin User");
	}

	@GetMapping("/public")
	public ResponseEntity<String> publicUser() {
		return ResponseEntity.ok("Yes, I am Public User");
	}

	// get single user
	@GetMapping("/{userName}")
	public User getUser(@PathVariable String userName) {
		return this.userService.getUser(userName);
	}

	// Add user
	@PostMapping("/getUser")
	public User add(@RequestBody User user) {
		return this.userService.addUser(user);
	}
}
