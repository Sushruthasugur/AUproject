package com.au.busreservation.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.busreservation.model.User;
import com.au.busreservation.repository.UserRepository;

@RestController
public class UserController 
{
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/addUser")
	public String saveUser(@RequestBody User User)
	{
		repository.save(User);
		return "User added successfully : " + User.getId();
	}
	
	@GetMapping("/findAllUsers")
	public List<User> getUsers()
	{
		return repository.findAll();
	}
	
	@GetMapping("/findAllUsers/{id}")
	public Optional<User> getUser(@PathVariable int id)
	{
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id)
	{
		repository.deleteById(id);
		return "User acc deleted based on id : " + id;
	}
	
}