package com.au.busreservation.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "bus")
public class Bus 
{
	@Id
	private String id;
	private String arrivalTime;
	private String departureTime;
	private Integer[] occupiedSeats;
	private Integer[] availableSeats;
	private int fare;
	private Routes routes;
	
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(String id, String arrivalTime, String departureTime, Integer[] occupiedSeats, Integer[] availableSeats,
			int fare, Routes routes) {
		super();
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.occupiedSeats = occupiedSeats;
		this.availableSeats = availableSeats;
		this.fare = fare;
		this.routes = routes;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getarrivalTime() {
		return arrivalTime;
	}

	public void setarrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getdepartureTime() {
		return departureTime;
	}

	public void setdepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Integer[] getoccupiedSeats() {
		return occupiedSeats;
	}

	public void setoccupiedSeats(Integer[] occupiedSeats) {
		this.occupiedSeats = occupiedSeats;
	}

	public Integer[] getavailableSeats() {
		return availableSeats;
	}

	public void setavailableSeats(Integer[] availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public Routes getRoutes() {
		return routes;
	}

	public void setRoutes(Routes routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime
				+ ", occupiedSeats=" + Arrays.toString(occupiedSeats) + ", availableSeats="
				+ Arrays.toString(availableSeats) + ", fare=" + fare + ", routes=" + routes + "]";
	}
	
}
