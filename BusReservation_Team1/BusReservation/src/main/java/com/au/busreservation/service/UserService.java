package com.au.busreservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.au.busreservation.model.User;
import com.au.busreservation.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository userrepo;

	//to add a user
	public User saveUser(User user) 
	{
		return userrepo.save(user);
	}
	
	//to get all the user details
	public List<User> getUsers() 
	{
		return userrepo.findAll();
	}
	
	//to get a particular user details
	public Optional<User> getUser(int id) 
	{
		return userrepo.findById(id);
	}
	
	//to delete a particular user
	public String deleteUser(int id) 
	{
		userrepo.deleteById(id);
		return "User acc deleted based on id : " + id;
	}
	public List<User> getAllByExample(User user) 
	{
		Example<User> u = Example.of(user);
		return userrepo.findAll(u);
	}	

}
