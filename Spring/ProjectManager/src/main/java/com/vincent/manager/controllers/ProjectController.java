package com.vincent.manager.controllers;

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

import com.vincent.manager.models.Project;
import com.vincent.manager.services.ProjectService;
import com.vincent.manager.services.UserService;

@Controller
public class ProjectController {
	
	@Autowired
    private UserService userServ;
	
	@Autowired
    private ProjectService projectServ;

	@GetMapping("/projects/new")
	public String newBook(@ModelAttribute("project") Project project, HttpSession session, Model model) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		return "newProject.jsp";
	}
	
	@PostMapping("/projects/create")
	public String createBook(@Valid @ModelAttribute("project") Project project, BindingResult result) {
		if(result.hasErrors()) {
			return "newProject.jsp";
		} else {
			projectServ.createProject(project);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/projects/{projectID}")
	public String viewBook(@PathVariable("projectID") Long id, HttpSession session, Model model) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		Project project = projectServ.findProject(id);
		model.addAttribute("oneProject", project);
		
		return "viewProject.jsp";
	}
	
	@GetMapping("/projects/{projectID}/edit")
	public String edit(@PathVariable("projectID") Long id, Model model, HttpSession session) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		Project project = projectServ.findProject(id);
		model.addAttribute("oneProject",project);
		
		return "editProject.jsp";
	}
	
	@PutMapping("/projects/{projectID}/update")
	public String update(@Valid @ModelAttribute("oneBook") Project project, BindingResult result, @PathVariable("projectID") Long id) {
		if(result.hasErrors()) {
			
			return "editBook.jsp";
		} else {
			Project p = projectServ.findProject(id);
			p.setTitle(project.getTitle());
			p.setDescription(project.getDescription());
			p.setDueBy(project.getDueBy());
			
			projectServ.createProject(p);
			return "redirect:/dashboard";
		}
	}
}
