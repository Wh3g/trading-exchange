package com.wh.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/users/{email}/{password}")
	public Optional<User> login(@PathVariable("email") String email, @PathVariable("password") String password) {
		return service.getUser(email, password);
	}

	@PutMapping("/users/username/{username}/{email}")
	public ResponseEntity<String> updateUsername(@PathVariable("username") String username, @PathVariable("email") String email) {
		service.updateUsername(username, email);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@PutMapping("/users/password/{newPassword}/{email}/{oldPassword}")
	public ResponseEntity<String> updatePassword(
			@PathVariable("newPassword") String newPassword, 
			@PathVariable("email") String email, 
			@PathVariable("oldPassword") String oldPassword) {
		service.updatePassword(newPassword, email, oldPassword);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@DeleteMapping("/users")
	public ResponseEntity<String> deleteUser(@RequestBody User user) {
		service.deleteUser(user);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}
