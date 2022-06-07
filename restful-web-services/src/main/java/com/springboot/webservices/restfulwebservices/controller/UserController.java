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

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return service.retrieveAll();
	}

	@GetMapping(path = "/users/{id}")
	public User getUserbyId(@PathVariable int id) {
		return service.findOne(id);
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		User createdUser = service.createUser(user);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdUser.getUserId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
