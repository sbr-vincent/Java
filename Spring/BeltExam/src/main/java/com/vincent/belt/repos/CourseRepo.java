package com.vincent.belt.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vincent.belt.models.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long>{
	ArrayList<Course> findAll();

}
