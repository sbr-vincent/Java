package com.vincent.mvc.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vincent.mvc.models.Book;
import com.vincent.mvc.repos.BookRepos;


@Service
public class BookService {
	private final BookRepos bookRepository;
	
	public BookService(BookRepos bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public ArrayList<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

	public Book updateBook(Long id, String title, String description, String language, Integer numberOfPages) {
		// TODO Auto-generated method stub
		Book updateBook = new Book();
		updateBook.setId(id);
		updateBook.setTitle(title);
		updateBook.setDescription(description);
		updateBook.setLanguage(language);
		updateBook.setNumberOfPages(numberOfPages);
		
		return bookRepository.save(updateBook);
	}

	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

}
