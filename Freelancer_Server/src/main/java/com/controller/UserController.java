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
import com.responseParams.UserLoginResponse;
import com.service.UserService;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
   
	@Autowired
    private UserService userService;

    @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> addNewUser (@RequestBody User user, HttpSession session) {
        if(session.getAttribute("email")!= null ) {
    		userService.addUser(user);
            System.out.println("Saved");
            return new ResponseEntity(null,HttpStatus.CREATED);
    	}
    	return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
        
    }

    @GetMapping(path="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON with the users
        return userService.getAllUsers();
    }

    @PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody User user, HttpSession session)
    {
    	
    	UserLoginResponse obj = (UserLoginResponse)userService.login(user);
    	if(obj.isLoggedIn()) {
    		 return new ResponseEntity(obj,HttpStatus.OK);
    	}else {
    		 return new ResponseEntity(null,HttpStatus.UNAUTHORIZED);
    	}
    	
       
    }

    
    @PostMapping(path="/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody User user)
    {
    	System.out.println("enetered in signup api");
    	Response res = (Response) userService.signup(user);
    	if(res.getCode() == 200) {
    		return new ResponseEntity(user,HttpStatus.OK);
    	}else {
    		return new ResponseEntity(user,HttpStatus.BAD_REQUEST);
    	}
    	
    	
       
    }
    
    
    @PostMapping(path="/projects",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody Projects project)
    {
    	Response res = (Response) userService.add(project);
    	if(res.getCode() == 200) {
    		return new ResponseEntity(res,HttpStatus.OK);
    	}else {
    		return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
    	}
    }
    
    
    
    @PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println(session.getAttribute("name"));
        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }
}