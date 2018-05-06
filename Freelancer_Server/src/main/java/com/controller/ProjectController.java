package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.entity.Projects;
import com.entity.User;
import com.responseParams.Response;
import com.service.ProjectService;
import com.service.UserService;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/project") // This means URL's start with /demo (after Application path)
public class ProjectController {
   
	@Autowired
    private ProjectService projectService;
    
    @GetMapping(path="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Projects> allProjects() {
        // This returns a JSON with the projects
        return projectService.allProjects();
    }
    
    @PostMapping(path="/postproject",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postproject(@RequestBody Projects project)
    {
    	System.out.println("enetered in postproject api");
    	Response res = (Response) projectService.postproject(project);
    	if(res.getCode() == 200) {
    		return new ResponseEntity(project,HttpStatus.OK);
    	}else {
    		return new ResponseEntity(project,HttpStatus.BAD_REQUEST);
    	}
       
    }
    
}