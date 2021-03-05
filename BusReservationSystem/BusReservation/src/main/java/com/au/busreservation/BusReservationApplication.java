package com.au.busreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.au.busreservation.repository.UserRepository;

@SpringBootApplication
public class BusReservationApplication  implements CommandLineRunner{

	@Autowired
	UserRepository userrepo;

	public static void main(String[] args) {
		SpringApplication.run(BusReservationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		
	}
}
