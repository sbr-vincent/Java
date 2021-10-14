package com.vincent.ninja.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vincent.ninja.models.Ninja;
public interface NinjaRepos extends CrudRepository<Ninja, Long>{
	// this method retrieves all the books from the database
    ArrayList<Ninja> findAll();
    // this method finds books with descriptions containing the search string
//    ArrayList<Ninja> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
}
