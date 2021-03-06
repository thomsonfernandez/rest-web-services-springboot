package com.springboot.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.webservices.restfulwebservices.beans.User;
import com.springboot.webservices.restfulwebservices.dao.UserDaoService;
import com.springboot.webservices.restfulwebservices.exceptions.NoUserToInsertOrCreatedException;
import com.springboot.webservices.restfulwebservices.exceptions.NoUsersException;
import com.springboot.webservices.restfulwebservices.exceptions.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping(path = "/users")
	public List<User> getUsers() {
		List<User> users = service.retrieveAll();
		if(users == null || users.size() == 0)
			throw new NoUsersException("No user found!!");
		return users;
	}

	@GetMapping(path = "/users/{id}")
	public User getUserbyId(@PathVariable int id) {
		 User user = service.findOne(id);
		 if(user == null)
			 throw new UserNotFoundException("Id : "+id);
		 return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		if(user == null)
			throw new NoUserToInsertOrCreatedException("No user to insert!!");
		
		User createdUser = service.createUser(user);

		if(createdUser == null)
			throw new NoUserToInsertOrCreatedException("No user to insert!!");
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdUser.getUserId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
