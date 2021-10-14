package com.vincent.ninja.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vincent.ninja.models.Dojo;


public interface DojoRepos extends CrudRepository<Dojo, Long>{
	// this method retrieves all the books from the database
    ArrayList<Dojo> findAll();
    // this method finds books with descriptions containing the search string
//    ArrayList<Dojo> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
	
}
