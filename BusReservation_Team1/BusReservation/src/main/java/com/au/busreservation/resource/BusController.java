package com.au.busreservation.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.busreservation.model.Bus;
import com.au.busreservation.service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController 
{
	@Autowired
	BusService busService;
	
	
	//To add a new bus
	@PostMapping("/addBus")
	public String saveBus(@RequestBody Bus bus)
	{
		return busService.saveBus(bus);
	}
	
	//To update a bus
	@PostMapping("/updateBus")
	public String updateBus(@RequestBody Bus bus)
	{
		return busService.updateBus(bus);
	}
	
	//to display all the bus details
	@GetMapping("/getAllBuses")
	public List<Bus> getBuses()
	{
		return busService.getBuses();
	}
	
	//to delete all bus details
	@DeleteMapping("/deleteBuses")
	public String deleteBuses()
	{
		return busService.deleteBuses();
	}
	
	//to delete a particular bus
	@DeleteMapping("/deleteBus/'{id}'")
	public String deleteBus(@PathVariable String id)
	{
		return busService.deleteBus(id);
	}
	
	//(search)display available buses when source and destination are given
	@GetMapping("/sourcedestination")
	public List<Bus> findAllBySourceAndDestination(@RequestParam(name="source") String source , @RequestParam( name ="destination") String destination)
	{
		return busService.findAllBySourceAndDestination(source , destination);
	}
	
	//(available seats)to display available seats in a bus selected by a user
	@GetMapping("/sourcedestinationid")
	public List<Bus> findAllBySourceAndDestinationAndid(@RequestParam(name="source") String source , @RequestParam( name ="destination") String destination , @RequestParam( name ="id") String id)
	{
		return busService.findAllBySourceAndDestinationAndId(source , destination , id);
	}
	
	//to display all the buses when source is given
	@GetMapping("/source")
	public List<Bus> findAllBySource(@RequestParam(name="source") String source)
	{
		return busService.findAllBySource(source);
	}
	
	
	
	
	
}
