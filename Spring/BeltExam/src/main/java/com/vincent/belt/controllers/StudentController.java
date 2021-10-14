package com.vincent.belt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vincent.belt.models.Student;
import com.vincent.belt.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService sServe;
	
	@PostMapping("/students/create")
	public String createStudent(@ModelAttribute("student") Student student) {
		sServe.save(student);
		return "redirect:/dashboard";
	}
}
