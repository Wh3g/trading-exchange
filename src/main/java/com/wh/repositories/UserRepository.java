package com.wh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wh.entities.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT u FROM User u WHERE email = :email AND password = :password")
	public Optional<User> getUser(@Param("email") String email, @Param("password") String password);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.username = :username WHERE u.email = :email")
	public void updateUsername(@Param("username") String username, @Param("email") String email);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.password = :newPassword WHERE u.email = :email AND password = :oldPassword")
	public void updatePassword(@Param("newPassword") String newPassword, @Param("email") String email, @Param("oldPassword") String oldPassword);
}
