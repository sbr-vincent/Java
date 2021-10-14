package com.vincent.manager.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.vincent.manager.models.Project;

public interface ProjectRepo extends CrudRepository<Project, Long> {
	ArrayList<Project> findAll();

}
