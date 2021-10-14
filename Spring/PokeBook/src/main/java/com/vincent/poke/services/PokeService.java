package com.vincent.poke.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vincent.poke.models.Poke;
import com.vincent.poke.repos.PokeRepos;


@Service
public class PokeService {
	private final PokeRepos pokeRepository;
	
	public PokeService(PokeRepos pokeRepository) {
		this.pokeRepository = pokeRepository;
	}
	
	// returns all the books
    public ArrayList<Poke> allBooks() {
        return pokeRepository.findAll();
    }
    // creates a book
    public Poke createBook(Poke b) {
        return pokeRepository.save(b);
    }
    // retrieves a book
    public Poke findBook(Long id) {
        Optional<Poke> optionalBook = pokeRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

	public Poke updateBook(Long id, String expense, String vendor, Double amount, String description) {
		// TODO Auto-generated method stub
		Poke updateBook = new Poke();
		updateBook.setId(id);
		updateBook.setExpense(expense);
		updateBook.setVendor(vendor);
		updateBook.setAmount(amount);
		updateBook.setDescription(description);
		
		return pokeRepository.save(updateBook);
	}

	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		pokeRepository.deleteById(id);
	}
}
