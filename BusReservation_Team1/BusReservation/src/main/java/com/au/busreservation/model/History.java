package com.au.busreservation.model;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "history")
public class History 
{
	private int userId;
	private String journey;
	private String dateOfJourney;
	private int amountPaid;
	private int totalNoOfSeats;
	private String dateOfBooking;
	private String status;
	public History() 
	{
		super();
	}
	public History(int userId, String journey, String dateOfJourney, int amountPaid, int totalNoOfSeats,String dateOfBooking, String status) {
		super();
		this.userId = userId;
		this.journey = journey;
		this.dateOfJourney = dateOfJourney;
		this.amountPaid = amountPaid;
		this.totalNoOfSeats = totalNoOfSeats;
		this.dateOfBooking = dateOfBooking;
		this.status = status;
	}
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	public String getJourney() {
		return journey;
	}
	public void setJourney(String journey) {
		this.journey = journey;
	}
	public String getDateOfJourney() 
	{
		return dateOfJourney;
	}
	public void setDateOfJourney(String dateOfJourney) 
	{
		this.dateOfJourney = dateOfJourney;
	}
	public int getAmountPaid() 
	{
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) 
	{
		this.amountPaid = amountPaid;
	}
	public int getTotalNoOfSeats() 
	{
		return totalNoOfSeats;
	}
	public void setTotalNoOfSeats(int totalNoOfSeats) 
	{
		this.totalNoOfSeats = totalNoOfSeats;
	}
	public String getDateOfBooking() 
	{
		return dateOfBooking;
	}
	public void setDateOfBooking(String dateOfBooking) 
	{
		this.dateOfBooking = dateOfBooking;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	@Override
	public String toString() {
		return "History [userId=" + userId + ", journey=" + journey + ", dateOfJourney=" + dateOfJourney
				+ ", amountPaid=" + amountPaid + ", totalNoOfSeats=" + totalNoOfSeats + ", dateOfBooking=" + dateOfBooking + ", status=" + status + "]";
	}
	
	
}
