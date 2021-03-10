package com.au.busreservation.model;
import java.util.Arrays;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ticket")
public class Ticket 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String busId;
	private String journeyDetails;
	private Integer[] seatNumbers;
	private int totalFare;
	private String dateOfJournery;
	private String payment;
	
	public Ticket() 
	{
		super();
	}

	public Ticket(int id, String busId, String journeyDetails , Integer[] seatNumbers,
			int totalFare, String dateOfJournery, String payment) 
	{
		super();
		this.id = id;
		this.busId = busId;
		this.journeyDetails = journeyDetails;
		this.seatNumbers = seatNumbers;
		this.totalFare = totalFare;
		this.dateOfJournery = dateOfJournery;
		this.payment = payment;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getJourneyDetails() {
		return journeyDetails;
	}

	public void setJourneyDetails(String journeyDetails) {
		this.journeyDetails = journeyDetails;
	}

	
	public Integer[] getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(Integer[] seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	public String getDateOfJournery() {
		return dateOfJournery;
	}

	public void setDateOfJournery(String dateOfJournery) {
		this.dateOfJournery = dateOfJournery;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", busId=" + busId + ", journeyDetails=" + journeyDetails + ", seatNumbers=" + Arrays.toString(seatNumbers) + ", totalFare=" + totalFare + ", dateOfJournery="
				+ dateOfJournery + ", payment=" + payment + "]";
	}
	
}
