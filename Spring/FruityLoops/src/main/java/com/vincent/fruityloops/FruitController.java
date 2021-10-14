package com.vincent.fruityloops;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruity.models.Item;

import java.util.ArrayList;

@Controller
public class FruitController {
	@RequestMapping("/")
	public String home(Model model) {
		ArrayList<Item> fruits = new ArrayList<Item>();
		fruits.add(new Item("Kiwi", 1.5));
		fruits.add(new Item("Mango", 2.0));
		fruits.add(new Item("Goji Berries", 4.0));
		fruits.add(new Item("Guava", .75));
		
		//Add to the view model
		model.addAttribute("fruityloops", fruits);
		return "index.jsp";
	}

}
