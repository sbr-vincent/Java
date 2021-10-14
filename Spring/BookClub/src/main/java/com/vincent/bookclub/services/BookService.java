package com.vincent.bookclub.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vincent.bookclub.models.Book;
import com.vincent.bookclub.models.User;
import com.vincent.bookclub.repos.BookRepo;

@Service
public class BookService {
	private final BookRepo bookRepository;
	
	public BookService(BookRepo bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public ArrayList<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	//Create a Book
		public Book createBook(Book b) {
			return bookRepository.save(b);
		}
		
		// Retrieves a Book
		public Book findBook(Long id) {
			Optional<Book> optionalBook = bookRepository.findById(id);
			if(optionalBook.isPresent()) {
				return optionalBook.get();
			} else {
				return null;
			}
		}
		
		public void deleteBook(Long id) {
			bookRepository.deleteById(id);
		}
}
