package com.vincent.manager.services;

import java.util.ArrayList;
import java.util.Optional;
import com.vincent.manager.models.Project;
import com.vincent.manager.repo.ProjectRepo;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	private final ProjectRepo projectRepository;
	
	public ProjectService(ProjectRepo projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public ArrayList<Project> allProjects() {
		return projectRepository.findAll();
	}
	
	//Create a Project
		public Project createProject(Project p) {
			return projectRepository.save(p);
		}
		
		// Retrieves a Book
		public Project findProject(Long id) {
			Optional<Project> optionalProject = projectRepository.findById(id);
			if(optionalProject.isPresent()) {
				return optionalProject.get();
			} else {
				return null;
			}
		}
		
		public void deleteProject(Long id) {
			projectRepository.deleteById(id);
		}
	
}
