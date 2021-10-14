package com.vincent.belt.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vincent.belt.models.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long>{
	ArrayList<Student> findAll();

}
