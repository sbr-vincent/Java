package com.vincent.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/hello")
@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("dojoName", "Burbank");
		return "index.jsp";
	}
//	@RequestMapping("")
//	public String index(@RequestParam(value="q", required=false) String searchQuery) {
//		return "You searched for: " + searchQuery;
//	}
//	
//	@RequestMapping("/new_route")
//	public String day() {
//		return "It's Friday, Friday!! Going to get down on Friday!!!";
//	}
//	
//	@RequestMapping("/world")
//	public String world() {
//		return "Class level annotations are cool too!";
//	}

}
