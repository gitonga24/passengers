package org.plutoair.passengers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FlightController {

	
	@Resource
	public FlightRepository flightRepo;
	
	@Resource
	public PassengerRepository passengerRepo;
	
	
	@RequestMapping ("/allFlights")
	public String findAllFlights(Model model) {
		model.addAttribute("allFlights", flightRepo.findAll());
		return "allFlights";
	}
	
	
	@RequestMapping ("/flight")
	public String findOneFlight (@RequestParam (value="id") long flightId, Model model) throws FlightNotFoundException {
			Optional<Flight> sanToMiami = flightRepo.findById(flightId);
		
		if(sanToMiami.isPresent()) {
			model.addAttribute("flight", sanToMiami.get());
			return "flight";
		}
		throw new FlightNotFoundException();
	}
	
	
	@RequestMapping("/passenger")
	public String findOnePassenger(@RequestParam (value="id") long passengerId, Model model) throws PassengerNotFoundException {
		Optional<Passenger> lemon = passengerRepo.findById(passengerId);
		
		if(lemon.isPresent()) {
			model.addAttribute("passenger", lemon.get());
			return "passenger";
		}
		throw new PassengerNotFoundException();
		
	}
	
	
	@RequestMapping ("/allPassengers")
	public String findAllPassengers(Model model) {
		model.addAttribute("allPassengers", passengerRepo.findAll());
		return "allPassengers";
	}
	
	
	
	
}
