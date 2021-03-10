package com.au.busreservation.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.au.busreservation.model.Ticket;
import com.au.busreservation.repository.TicketRepository;

@Service
public class TicketService 
{
	@Autowired
	TicketRepository ticketrepo;
	public List<Ticket> getTickets() {
		return ticketrepo.findAll();
	}
	public Optional<Ticket> getById(int id) {
		return ticketrepo.findById(id);
	}
	public List<Ticket> getByIdAndBusId(int id , String busId)
	{
		return ticketrepo.getByIdAndBusId(id,busId);
	}
	public void deleteTicket(int id) 
	{
		ticketrepo.deleteById(id);
	}
}
