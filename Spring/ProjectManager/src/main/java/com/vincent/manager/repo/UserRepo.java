package com.vincent.manager.repo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vincent.manager.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	ArrayList<User> findAll();

}
