package com.wh.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.entities.User;
import com.wh.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User createUser(User user) {
		return repository.save(user);
	}

	@Override
	public Optional<User> getUser(String email, String password) {
		return repository.getUser(email, password);
	}

	@Override
	public void updateUsername(String username, String email) {
		repository.updateUsername(username, email);
	}

	@Override
	public void updatePassword(String newPassword, String email, String oldPassword) {
		repository.updatePassword(newPassword, email, oldPassword);
	}

	@Override
	public void deleteUser(User user) {
		repository.delete(user);
	}

}
