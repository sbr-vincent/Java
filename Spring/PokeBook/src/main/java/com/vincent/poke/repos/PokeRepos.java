package com.vincent.poke.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vincent.poke.models.Poke;

@Repository
public interface PokeRepos extends CrudRepository<Poke, Long>{
	// this method retrieves all the books from the database
    ArrayList<Poke> findAll();
    // this method finds books with descriptions containing the search string
    ArrayList<Poke> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
}
