package com.repository;

import com.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface UserRepository extends CrudRepository<User, Integer> {
    
	List<User> findByEmailAndPassword(String email,String password);
	List<User> findByEmail(String email);
}