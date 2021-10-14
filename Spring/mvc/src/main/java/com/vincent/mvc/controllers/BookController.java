package com.vincent.mvc.controllers;

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

import com.vincent.mvc.models.Book;
import com.vincent.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String index(@PathVariable("bookId") Long bookId, Model model) {
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		 List<Book> books = bookService.allBooks();
		 model.addAttribute("books", books);
		 return "index.jsp";
	}
	
	@GetMapping("/books/new") 
	public String newBook(@ModelAttribute("book") Book book) {
			return "new.jsp";
	}
	
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	
}
