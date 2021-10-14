package com.vincent.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vincent.mvc.models.Book;
import com.vincent.mvc.services.BookService;

@RestController
public class BookApi {
	public final BookService bServ;
	
	public BookApi(BookService serv) {
		this.bServ = serv;
	}
	
	@GetMapping("/api/books")
	public List<Book> getAllBooks() {
		List<Book> allBooks = bServ.allBooks();
		
		return allBooks;
	}
	
	@PostMapping("/api/books/create")
	public Book createBook(
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages
	) {
		Book book = new Book(title, description, language, numberOfPages);
		
		return bServ.createBook(book);
	}
	
	@GetMapping("/api/books/{id}")
	public Book getOneBook(@PathVariable("id") Long id) {
		return bServ.findBook(id);
	}
	
	@PutMapping("/api/books/{id}")
	public Book update(
			@PathVariable("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages) {
		Book book = bServ.updateBook(id, title, description, language, numberOfPages);
		return book;
	}
	
	@DeleteMapping("/api/books/{id}")
	public void destroy(@PathVariable("id") Long id) {
		bServ.deleteBook(id);
	}
	
}
