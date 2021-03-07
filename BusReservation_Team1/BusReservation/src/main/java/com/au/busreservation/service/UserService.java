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
	public String saveUser(User user) 
	{
		userrepo.save(user);
		return "User added successfully : " + user.getId();
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

	public List<User> getByFirstname(String firstname) 
	{
		return userrepo.findByFirstname(firstname);
	}
	
	public List<User> getAllByExample(User user) 
	{
		Example<User> u = Example.of(user);
		return userrepo.findAll(u);
	}	

}
