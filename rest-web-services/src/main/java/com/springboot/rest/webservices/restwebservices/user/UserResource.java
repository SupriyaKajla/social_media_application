package com.springboot.rest.webservices.restwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping ("/users")
	public List<User> getAllUsers() {
		return service.findUsers();
	}
	
	@GetMapping ("/users/{id}")
	public User getUser(@PathVariable Integer id) {
		 User user = service.findUser(id);
		 
		 if(user == null)
			 throw new UserNotFoundException("id"+id);
		 return user;
	}
	
	@DeleteMapping ("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		 service.deleteById(id);
		 
	}
	
	@PostMapping ("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = service.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri() ;
		return ResponseEntity.created(location).build();
	}
	

}
