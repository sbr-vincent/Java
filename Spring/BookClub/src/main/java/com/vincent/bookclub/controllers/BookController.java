package com.vincent.bookclub.controllers;



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

import com.vincent.bookclub.models.Book;
import com.vincent.bookclub.services.BookService;
import com.vincent.bookclub.services.UserServices;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
    private UserServices userServ;
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		return "newBook.jsp";
	}
	
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{bookID}")
	public String viewBook(@PathVariable("bookID") Long id, HttpSession session, Model model) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		Book book = bookService.findBook(id);
		model.addAttribute("oneBook", book);
		
		return "viewBook.jsp";
	}
	
	@GetMapping("/books/{bookID}/edit")
	public String edit(@PathVariable("bookID") Long id, Model model, HttpSession session) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		Book book = bookService.findBook(id);
		model.addAttribute("oneBook",book);
		
		return "editBook.jsp";
	}
	
	@PutMapping("/books/{bookID}/update")
	public String update(@Valid @ModelAttribute("oneBook") Book book, BindingResult result, @PathVariable("bookID") Long id) {
		if(result.hasErrors()) {
			
			return "editBook.jsp";
		} else {
			Book b = bookService.findBook(id);
			b.setTitle(book.getTitle());
			b.setAuthor(book.getAuthor());
			b.setThoughts(book.getThoughts());
			
			bookService.createBook(b);
			return "redirect:/books";
		}
	}
	
	
	
}
