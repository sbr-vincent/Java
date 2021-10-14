package com.vincent.belt.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vincent.belt.models.Course;
import com.vincent.belt.models.Student;
import com.vincent.belt.services.CourseService;
import com.vincent.belt.services.StudentService;
import com.vincent.belt.services.UserService;


@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private StudentService sServe;
	
	@GetMapping("/courses/new")
	public String newCourse(@ModelAttribute("course") Course course, HttpSession session, Model model) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		return "courseNew.jsp";
	}

	@PostMapping("/courses/create")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
			return "courseNew.jsp";
		} else {
			courseService.createCourse(course);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/courses/{courseID}/edit")
	public String edit(@PathVariable("courseID") Long id, Model model, HttpSession session) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		Course course = courseService.findCourse(id);
		model.addAttribute("oneCourse",course);
		
		return "editCourse.jsp";
	}
	
	@PutMapping("/courses/{courseID}/update")
	public String update(@Valid @ModelAttribute("oneCourse") Course course, BindingResult result, @PathVariable("courseID") Long id) {
		if(result.hasErrors()) {
			return "editCourse.jsp";
		} else {
			Course c = courseService.findCourse(id);
			c.setCourseName(course.getCourseName());
			c.setDay(course.getDay());
			c.setPrice(course.getPrice());
			c.setTime(course.getTime());
			
			courseService.createCourse(c);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/courses/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		courseService.deleteCourse(id);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/courses/{courseID}")
	public String display(@PathVariable("courseID") Long id, Model model) {
		Course course = courseService.findCourse(id);
		model.addAttribute("oneCourse", course);
		model.addAttribute("student", new Student());
		model.addAttribute("allStudents", sServe.getAll());
		
		return "showCourse.jsp";
	}
	
	@PostMapping("/courses/{courseId}/addStudent")
	public String addStudent(@PathVariable("courseId") Long courseId, @RequestParam("studentId") Long studentId) {
		sServe.addToCourse(studentId, courseId);
		
		return "redirect:/courses/" + courseId;
	}
	
}
