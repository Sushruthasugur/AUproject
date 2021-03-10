package com.au.busreservation.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.au.busreservation.model.Ticket;

@Repository
public interface TicketRepository  extends MongoRepository<Ticket,String>
{

	Optional<Ticket> findById(int id);

	List<Ticket> getByIdAndBusId(int id , String busId);

	void deleteById(int id);

}
