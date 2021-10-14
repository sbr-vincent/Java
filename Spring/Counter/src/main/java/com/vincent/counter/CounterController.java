package com.vincent.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/your_server")
	public String welcome(HttpSession session, Model model) {
		
		if (session.getAttribute("count") == null) {
			//Use setAttribute to initialize the count in session
			session.setAttribute("count", 1);
		}
		else {
			//increment the count by 1 using getAttribute and setAttribute
			Integer currentCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", currentCount+1);
		}

		return "showCount.jsp";
	}
	
	@RequestMapping("/your_server/counter")
	public String home(HttpSession session, Model model) {
		
		if (session.getAttribute("count") == null) {
			//Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
		}
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "index.jsp";
	}
	
	
}
