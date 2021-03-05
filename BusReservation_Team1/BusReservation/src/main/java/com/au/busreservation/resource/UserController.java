package com.au.busreservation.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.busreservation.model.User;
import com.au.busreservation.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserRepository userrepo;

//	@Autowired
//	private userService userser;
//	@GetMapping("/name")
//	public List<User> getByName(@RequestParam(name = "firstname") String name) {
//		return userser.getByName(name);
//	}
	
	@PostMapping("/addUser")
	public String saveUser(@RequestBody User user)
	{
		userrepo.save(user);
		return "User added successfully : " + user.getId();
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers()
	{
		return userrepo.findAll();
	}
	
	@GetMapping("/getAllUsers/{id}")
	public Optional<User> getUser(@PathVariable int id)
	{
		return userrepo.findById(id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{
		userrepo.deleteById(id);
		return "User acc deleted based on id : " + id;
	}

	
//	public List<User> getAllUsers(String lastname)
//	{
//		String name=lastname;
//		List<User> temp = userrepo.findAll();
//		if(temp.contains(name))
//		{
//			return temp;
//		}
//		else
//		return new ArrayList<User>();
//	}
	
	
	
}