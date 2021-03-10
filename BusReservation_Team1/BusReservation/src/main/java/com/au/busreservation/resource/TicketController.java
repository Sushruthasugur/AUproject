package com.au.busreservation.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.busreservation.model.Bus;
import com.au.busreservation.model.Ticket;
import com.au.busreservation.service.BusService;
import com.au.busreservation.service.HistoryService;
import com.au.busreservation.service.TicketService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController 
{
	@Autowired
	TicketService ticketService;

	@Autowired
	BusService busService;
	
	@Autowired
	HistoryService historyService;
	
	@GetMapping("/getAllTickets")
	public List<Ticket> getTickets()
	{
		return ticketService.getTickets();
	}
	@GetMapping("/getTicketById")
	public Optional<Ticket> getById(@RequestParam(name = "id") int id)
	{
		return ticketService.getById(id);
	}
	@PostMapping("/cancelticket")
	public String cancelticket(@RequestParam(name="id") int id , @RequestParam(name="busId") String busId)
	{
		List<Ticket> a = ticketService.getByIdAndBusId(id,busId);
		Integer[] a1=a.get(0).getSeatNumbers();
		List<Integer> myl=new ArrayList<>(Arrays.asList(a1));//Integer[] to list 
		String dateOfJourney = a.get(0).getDateOfJournery();
		List<Bus> b=busService.getByOccupiedSeats(busId);
		Integer[] b1=b.get(0).getoccupiedSeats();
		List<Integer> myl1=new ArrayList<>(Arrays.asList(b1));
		myl1.removeAll(myl);

		List<Bus> c=busService.getByAvailableSeats(busId);
		Integer[] c1=c.get(0).getavailableSeats();
		List<Integer> myl2=new ArrayList<>(Arrays.asList(c1));
		if(!myl2.containsAll(myl))
		{
			myl2.addAll(myl);
		}
		Integer[] arr1 = myl1.stream().toArray(Integer[]::new);
		Integer[] arr2 = myl2.stream().toArray(Integer[]::new);
		busService.updatingbusseats(busId,arr2,arr1);
		historyService.updatinghistory(id,dateOfJourney);
		ticketService.deleteTicket(id);
		return "Tickets Cancelled Successfully!";
	}
}
