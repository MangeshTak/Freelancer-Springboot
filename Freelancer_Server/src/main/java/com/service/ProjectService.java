package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Projects;
import com.entity.User;
import com.repository.ProjectsRepository;
import com.repository.UserRepository;
import com.responseParams.Response;

@Service
public class ProjectService {
	
	@Autowired
    private UserRepository userRepository;
	
    @Autowired
    private ProjectsRepository projectsRepository;

  	public Response add(Projects project) {
		User user = userRepository.findByEmail("palajs@gmail.com").get(0);
		
		project.setUser(user);
		projectsRepository.save(project);
		
		return new Response(201, "Project Submitted Successfully");
	}
  	
  	public Iterable<Projects> allProjects() {
		
		return projectsRepository.findAll();
		
	}

	public Response postproject(Projects project) {
				
		projectsRepository.save(project);
		return new Response(200, "Project created successfully") ;
		
	}
}