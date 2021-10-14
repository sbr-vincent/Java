package com.vincent.poke.controllers;

import java.util.List;

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

import com.vincent.poke.models.Poke;
import com.vincent.poke.services.PokeService;

@Controller
public class PokeController {
	@Autowired
	PokeService pokeService;
	
	@GetMapping("/books/{bookId}")
	public String index(@PathVariable("bookId") Long bookId, Model model) {
		System.out.println(bookId);
		Poke book = pokeService.findBook(bookId);
		System.out.println(book);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("poke") Poke poke) {
		 List<Poke> books = pokeService.allBooks();
		 model.addAttribute("books", books);
		 return "index.jsp";
	}
	
//	@GetMapping("/books/new") 
//	public String newBook(@ModelAttribute("poke") Poke poke) {
//			return "new.jsp";
//	}
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("poke") Poke poke, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			pokeService.createBook(poke);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/books/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		pokeService.deleteBook(id);
		
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Poke poke = pokeService.findBook(id);
		model.addAttribute("onePoke", poke);
		
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/{id}")
	public String update(@Valid @ModelAttribute("poke") Poke poke, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			pokeService.createBook(poke);
			return "redirect:/expenses";
		}
	}
}
