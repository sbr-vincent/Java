package com.vincent.ninja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vincent.ninja.models.Dojo;
import com.vincent.ninja.services.DojoService;

@Controller
public class DojoController {
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/dojos/{dojoId}")
	public String index(@PathVariable("dojoId") Long dojoId, Model model) {
		System.out.println(dojoId);
		model.addAttribute("allNinjas", dojoService.findDojo(dojoId));
		
		return "showDojo.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "dojoNew.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojoNew.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
}
