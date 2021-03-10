package com.au.busreservation.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.au.busreservation.model.Bus;
import com.au.busreservation.repository.BusRepository;

@Service
public class BusService 
{
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	BusRepository busrepo;

	//adds bus details
	public String saveBus(Bus bus) 
	{
		busrepo.insert(bus);
		return "Bus added successfully : " + bus.getid();
	}
	
	//updates bus details
	public String updateBus(Bus bus) 
	{
		busrepo.save(bus);
		return "Bus details updated successfully : " + bus.getid();
	}
	
	//gets bus details
	public List<Bus> getBuses() 
	{
		return busrepo.findAll();
	}
	
	//delete all bus details
	public String deleteBuses() 
	{
		busrepo.deleteAll();
		return "deleted all buses data..";
	}
	
	//delete particular bus
	public String deleteBus(String id) 
	{
		busrepo.deleteById(id);
		return "Bus data deleted Successfully : " + id;
	}
	
	//(search) to display all the buses when source and destination are given
	public List<Bus> findAllBySourceAndDestination(String source, String destination)
	{
		return busrepo.findAllByRoutesSourceAndRoutesDestination(source,destination);
	}

	//(Available seats) to display available seats in a bus selected by a user
	public List<Bus> findAllBySourceAndDestinationAndId(String source, String destination, String id) 
	{
		return busrepo.findAllByRoutesSourceAndRoutesDestinationAndId(source,destination,id);
	}
	
	//to display all the buses when source is given
	public List<Bus> findAllBySource(String source) 
	{	
		return busrepo.findAllByRoutesSource(source);
	}

	public String getByArrivalTime(String busid) 
	{
		return busrepo.getByArrivalTime(busid);
	}

	public String getByDepartureTime(String busid) 
	{
		return busrepo.getByDepartureTime(busid);
	}

	public String getByFare(String busid) 
	{
		return busrepo.getByFare(busid);
	}

	public Optional<Bus> getBus(String id) 
	{
		return busrepo.findById(id);
	}

	public List<Bus> getByAvailableSeats(String busid) 
	{
		return busrepo.getByAvailableSeats(busid);
	}

	public List<Bus> getByOccupiedSeats(String busid) 
	{
		return busrepo.getByoccupiedSeats(busid);
	}

	public void updatingbusseats( String busid, Integer[] arr2, Integer[] arr1 ) 
	{	
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(busid));
		Update update = new Update();
		update.set("availableSeats",arr2);
		update.set("occupiedSeats",arr1);
		mongoTemplate.updateMulti(query, update, Bus.class);
	}

}
