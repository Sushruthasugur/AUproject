package com.au.busreservation.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.busreservation.model.User;
import com.au.busreservation.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserService userService;	

	//to add a user
	@PostMapping("/addUser")
	public String saveUser(@RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	//to get all the user details
	@GetMapping("/getAllUsers")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	//to get a particular user details
	@GetMapping("/getAllUsers/{id}")
	public Optional<User> getUser(@PathVariable int id)
	{
		return userService.getUser(id);
	}
	
	//to delete a particular user
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{
		return userService.deleteUser(id);
	}

	
	//to get all the user details based on firstname
	@GetMapping(value = "/firstname")
	public ResponseEntity<?> getByFirstname(@RequestParam(name = "firstname") String firstname) 
	{
		List<User> u = userService.getByFirstname(firstname);
		if (u.size() > 0) 
		{
			return new ResponseEntity<List<User>>(u, HttpStatus.OK);
		} 
			else 
		{
			return new ResponseEntity<>("No User avaialable with name " + firstname, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/example")
	public List<User> getAllByExample(@RequestBody User user)
	{
		return userService.getAllByExample(user);
	}
	
}