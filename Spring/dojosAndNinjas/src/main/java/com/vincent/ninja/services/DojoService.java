package com.vincent.ninja.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vincent.ninja.models.Dojo;
import com.vincent.ninja.models.Ninja;
import com.vincent.ninja.repos.DojoRepos;

@Service
public class DojoService {
	private final DojoRepos dojoRepository;
	
	public DojoService(DojoRepos dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	// returns all the dojos
	public ArrayList<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	//Create a dojo
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	// Retrieves a dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public Dojo updateDojo(Long id, String name, List<Ninja> ninjas) {
		Dojo updateDojo = new Dojo();
		updateDojo.setId(id);
		updateDojo.setName(name);
		updateDojo.setNinjas(ninjas);
		
		return dojoRepository.save(updateDojo);
	}
	
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
}
