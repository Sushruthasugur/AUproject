package com.au.busreservation.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.busreservation.model.User;

@Repository
public interface UserRepository extends MongoRepository<User , Integer>
{
	
}
