package com.au.busreservation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.au.busreservation.model.User;

public interface UserRepository extends MongoRepository<User , Integer>
{
	
}
