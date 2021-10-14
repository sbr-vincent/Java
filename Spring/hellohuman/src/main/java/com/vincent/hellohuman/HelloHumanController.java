package com.vincent.hellohuman;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloHumanController {
	@RequestMapping("/")
	public String human(@RequestParam(value="q", required=false) String searchQuery, String lastName) {
		if(searchQuery == null) {
			return "Hello Human"; 
		}
		
		if(lastName == null) {
			lastName = "";
		}
		
		String message = "Blop " + searchQuery + " " + lastName;
		
		return message;
	}
}
