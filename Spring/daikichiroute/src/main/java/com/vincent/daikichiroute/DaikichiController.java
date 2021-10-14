package com.vincent.daikichiroute;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, ann oppurtunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/{action}/{location}")
	public String travel(@PathVariable("action") String action, @PathVariable("location") String location) {
		return "Congratulations! You will soon " + action + " to " + location;
	}
	
	@RequestMapping("/lotto/{number}")
	public String fortune(@PathVariable("number") Integer number) {
		if(number %2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
}
