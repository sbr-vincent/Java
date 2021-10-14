package com.vincent.ninja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vincent.ninja.models.Ninja;
import com.vincent.ninja.services.DojoService;
import com.vincent.ninja.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoService.allDojos());
		return "ninjaNew.jsp";
	}

	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allDojos", dojoService.allDojos());
			return "ninjaNew.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
