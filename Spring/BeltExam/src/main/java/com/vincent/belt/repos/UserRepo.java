package com.vincent.belt.repos;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vincent.belt.models.User;
public interface UserRepo  extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
	ArrayList<User> findAll();

}
