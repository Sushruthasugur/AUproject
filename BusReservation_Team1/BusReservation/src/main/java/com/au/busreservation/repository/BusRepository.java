package com.au.busreservation.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.busreservation.model.Bus;

@Repository
public interface BusRepository extends MongoRepository<Bus,String>
{

	List<Bus> findAllByRoutesSource(String source);
	
	//(search) to display all the buses when source and destination are given
	@Query(value="{'routes.source' : ?0 , 'routes.destination' : ?1}" ,  fields = "{'routes' : 0 , 'occupiedSeats' : 0 , 'availableSeats' : 0}")
	List<Bus> findAllByRoutesSourceAndRoutesDestination(String source, String destination);

	//(Available seats) to display available seats in a bus selected by a user
	@Query(value="{'routes.source' : ?0 , 'routes.destination' : ?1 , 'id' : ?2}" ,  fields = "{'availableSeats' : 1,'fare' : 1}")
	List<Bus> findAllByRoutesSourceAndRoutesDestinationAndId(String source, String destination, String id);

	Integer[] findAllByAvailableSeatsAndId(Integer[] temp);

	@Query(value="{'id' : ?0}",fields = "{'id': 0 , 'arrivalTime' : 1}")
	String getByArrivalTime(String busid);

	@Query(value="{'id' : ?0}",fields = "{'id': 0 , 'departureTime' : 1}")
	String getByDepartureTime(String busid);

	@Query(value="{'id' : ?0}",fields = "{'id': 0 , 'fare' : 1}")
	String getByFare(String busid);

	@Query(value="{'id' : ?0}",fields = "{'id': 0 , 'availableSeats' : 1}")
	List<Bus> getByAvailableSeats(String busid);

	@Query(value="{'id' : ?0}",fields = "{'id': 0 , 'occupiedSeats' : 1 , 'routes.source' : 1 , 'routes.destination' : 1 , 'arrivalTime' : 1 , 'fare' : 1}")
	List<Bus> getByoccupiedSeats(String busid);

}
