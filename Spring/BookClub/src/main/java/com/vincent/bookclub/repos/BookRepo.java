package com.vincent.bookclub.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.vincent.bookclub.models.Book;


public interface BookRepo extends CrudRepository<Book, Long>{
	ArrayList<Book> findAll();
}
