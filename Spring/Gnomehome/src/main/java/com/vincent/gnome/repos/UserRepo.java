package com.vincent.gnome.repos;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vincent.gnome.models.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
	ArrayList<User> findAll();

}
