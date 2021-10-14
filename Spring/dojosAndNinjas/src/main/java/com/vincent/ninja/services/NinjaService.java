package com.vincent.ninja.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vincent.ninja.models.Dojo;
import com.vincent.ninja.models.Ninja;
import com.vincent.ninja.repos.NinjaRepos;

@Service
public class NinjaService {
private final NinjaRepos ninjaRepository;
	
	public NinjaService(NinjaRepos ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	// returns all the ninjas
	public ArrayList<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	//Create a ninja
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	// Retrieves a ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public Ninja updateNinja(Long id, String firstName, String lastName, Integer age, Dojo dojo) {
		Ninja updateNinja = new Ninja();
		updateNinja.setId(id);
		updateNinja.setFirstName(firstName);
		updateNinja.setLastName(lastName);
		updateNinja.setAge(age);
		updateNinja.setDojo(dojo);
		
		return ninjaRepository.save(updateNinja);
	}
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
}
