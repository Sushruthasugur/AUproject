package com.au.busreservation.resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.au.busreservation.model.Bus;
import com.au.busreservation.model.History;
import com.au.busreservation.model.Ticket;
import com.au.busreservation.repository.BusRepository;
import com.au.busreservation.service.BusService; 
@RestController
@RequestMapping("/api/bus")
public class BusController 
{
	@Autowired
	BusService busService;
	@Autowired
	BusRepository busrepo;
	@Autowired
	MongoTemplate mongoTemplate;

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
	//to get a particular user details
	@GetMapping("/getBus/{id}")
	public Optional<Bus> getBus(@RequestParam String id)
	{
		return busService.getBus(id);
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
	@GetMapping(value="/sourcedestination",produces=MediaType.APPLICATION_JSON_VALUE)
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
	@PostMapping("/bookaseat")
	public String bookaseat(Bus bus,@RequestParam(name="selectedSeats") Integer[] selectedSeats,@RequestParam(name="busid") String busid,
			@RequestParam(name="userid") int userid ,@RequestParam(name="dateOfJourney") String dateOfJourney ,Integer[] availableSeats , Integer[] occupiedSeats)
	{	
		//retrieving all the occupied seats and updating
		List<Bus> a=busService.getByOccupiedSeats(busid);
		Integer[] a1=a.get(0).getoccupiedSeats();
		List<Integer> myl=new ArrayList<>(Arrays.asList(a1));//Integer[] to list
		List<Integer> myl1=new ArrayList<>(Arrays.asList(selectedSeats));//Integer[] to list
		if(!myl.containsAll(myl1))
		{
			myl.addAll(myl1);
		}
		Integer[] arr1 = myl.stream().toArray(Integer[]::new);//from list to Integer[] this contains updated occupied seats
		//retrieving all the available seats and updating
		List<Bus> b=busService.getByAvailableSeats(busid);
		Integer[] b1=b.get(0).getavailableSeats();
		List<Integer> myll=new ArrayList<>(Arrays.asList(b1));//Integer[] to list
		myll.removeAll(myl1);
		Integer[] arr2 = myll.stream().toArray(Integer[]::new);//from list to Integer[] this contains updated available seats
		//updating in bus document
		busService.updatingbusseats(busid,arr2,arr1);
		String dj=dateOfJourney;
		String at=a.get(0).getarrivalTime();
		String source=a.get(0).getRoutes().getsource();
		String destination=a.get(0).getRoutes().getDestination();
		String journeyDetails = "From:" + " " +source + " " + "To:" + " " + destination + " " + "ArrivalTime:" + " " + at;
		String journey = source + " " + "to" + " " + destination;
		int seats = selectedSeats.length;
		int tf=a.get(0).getFare()  * seats;
		Ticket t = new Ticket(userid,busid,journeyDetails,selectedSeats,tf ,dj,"Successful");
		mongoTemplate.save(t);
		Date date = new Date();
		History h = new History(userid,journey,dj,tf,seats,date.toString(),"Successful");
		mongoTemplate.insert(h);
		return "seat booked successfully get ur ticket /getticket";
	}
	
}