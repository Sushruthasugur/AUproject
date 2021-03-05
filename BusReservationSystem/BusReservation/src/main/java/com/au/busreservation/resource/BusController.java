package com.au.busreservation.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.busreservation.model.Bus;
import com.au.busreservation.repository.BusRepository;

@RestController
public class BusController 
{
	@Autowired
	private BusRepository busrepo;
	
	@PostMapping("/addBus")
	public String saveBus(@RequestBody Bus bus)
	{
		busrepo.save(bus);
		return "Bus added successfully : " + bus.getid();
	}
	
	@GetMapping("/getAllBuses")
	public List<Bus> getBuses()
	{
		return busrepo.findAll();
	}
	
	@DeleteMapping("/deleteBuses")
	public String deleteBuses()
	{
		busrepo.deleteAll();
		return "deleted all buses data..";
	}
	
	@GetMapping("/getbyfare?criteria=fare:1000")
	public List<Bus> getbyfare(@RequestParam("criteria")int fare)
	{
		return busrepo.findAll();
	}
	
	@DeleteMapping("/deleteBus/'{id}'")
	public String deleteBus(@PathVariable String id)
	{
		busrepo.deleteById(id);
		return "Bus data deleted Successfully : " + id;
	}
	
	
}
