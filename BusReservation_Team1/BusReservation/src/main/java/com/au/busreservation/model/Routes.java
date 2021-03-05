package com.au.busreservation.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Routes 
{
	@Id
	private String id;
	private String source;
	private String destination;
	public Routes() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Routes [source=" + source + ", destination=" + destination + "]";
	}
	public String getsource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Routes(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}
}
