package com.wh.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wh.entities.User;
import com.wh.services.UserService;

@RestController
public class UserRestController {

	@Autowired
	UserService service;

	@PostMapping("/users/")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User storedUser = service.createUser(user);
		return new ResponseEntity<User>(storedUser, HttpStatus.CREATED);
	}

}
