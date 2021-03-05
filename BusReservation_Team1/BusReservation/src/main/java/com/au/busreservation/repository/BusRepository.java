package com.au.busreservation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.busreservation.model.Bus;

@Repository
public interface BusRepository extends MongoRepository<Bus,String>
{
	//Bus getbyfare(Bus fare);
}
