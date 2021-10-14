package com.vincent.belt.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vincent.belt.models.Course;
import com.vincent.belt.repos.CourseRepo;


@Service
public class CourseService {
	private final CourseRepo courseRepository;
	
	public CourseService(CourseRepo courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	// returns all the Courses
		public ArrayList<Course> allCourses() {
			return courseRepository.findAll();
		}
		
		//Create a Course
		public Course createCourse(Course c) {
			return courseRepository.save(c);
		}
		
		// Retrieves a Course
		public Course findCourse(Long id) {
			Optional<Course> optionalNinja = courseRepository.findById(id);
			if(optionalNinja.isPresent()) {
				return optionalNinja.get();
			} else {
				return null;
			}
		}
		
		public void deleteCourse(Long id) {
			courseRepository.deleteById(id);
		}
		

}
