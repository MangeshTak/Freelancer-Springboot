package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Projects;
import com.entity.User;
import com.repository.ProjectsRepository;
import com.repository.UserRepository;
import com.responseParams.Response;
import com.responseParams.UserLoginResponse;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProjectsRepository projectsRepository;

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Object login(User user){
    	System.out.println("entered in login"+user.getEmail()+user.getPassword());
        List<User> userList = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        if(userList.size() > 0) {
        	return new UserLoginResponse(userList.get(0).getId(), true);
        }else {
        	return new UserLoginResponse(0, false);
        }
    }

	public Object signup(User user) {
		if(userRepository.findByEmail(user.getEmail()).size() > 0) {
			return new Response(400,"Email already in use");
			
			
		}else {
			
			// get Passowrd and hash it 
			// After hashing set it to the object
			
			userRepository.save(user);
			
			return new Response(201, "User created successfully") ;
		}
		
	}

	public Response add(Projects project) {
		User user = userRepository.findByEmail("palajs@gmail.com").get(0);
		
		project.setUser(user);
		projectsRepository.save(project);
		
		return new Response(201, "Project Submitted Successfully");
	}
}