package com.vincent.belt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincent.belt.models.Course;
import com.vincent.belt.models.Student;
import com.vincent.belt.repos.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private CourseService courseServ;
	
	public Student save(Student s) {
		return repo.save(s);
	}
	
	public List<Student> getAll() {
		return repo.findAll();
	}
	
	public Student getOne(Long id) {
		Optional<Student> stu = repo.findById(id);
		if(stu.isPresent()) {
			return stu.get();
		} else {
			return null;
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public Student addToCourse(Long studentID, Long courseID) {
		Student student = getOne(studentID);
		Course course = courseServ.findCourse(courseID);
		
		student.getCourses().add(course);
		
		return save(student);
	}
	
	public Student removeFromCourse(Long studentID, Long courseID) {
		Student student = getOne(studentID);
		Course course = courseServ.findCourse(courseID);
		
		student.getCourses().remove(course);
		
		return save(student);
	}
}
