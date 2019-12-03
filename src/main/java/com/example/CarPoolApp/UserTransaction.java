package com.example.CarPoolApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTransaction extends JpaRepository<User, Long> {

	List<User> findByUsernameStartsWithIgnoreCase(String password);
}
