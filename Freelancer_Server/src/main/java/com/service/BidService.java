package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Bid;
import com.entity.Projects;
import com.entity.User;
import com.repository.BidRepository;
import com.repository.ProjectsRepository;
import com.repository.UserRepository;
import com.responseParams.Response;

@Service
public class BidService {
	
	@Autowired
    private UserRepository userRepository;
	
    @Autowired
    private ProjectsRepository projectsRepository;
    
    @Autowired
    private BidRepository bidRepository;

  	public Response add(Projects project) {
		User user = userRepository.findByEmail("palajs@gmail.com").get(0);
		
		project.setUser(user);
		projectsRepository.save(project);
		
		return new Response(201, "Project Submitted Successfully");
	}
  	
  	public Iterable<Bid> allBid() {
		
		return bidRepository.findAll();
		
	}
}