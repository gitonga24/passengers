package org.plutoair.passengers;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlightPopulator implements CommandLineRunner {

	@Resource
	private FlightRepository flightRepo;
	
	@Resource
	private PassengerRepository passengerRepo;
	
	public void run(String... args) throws Exception {
		
		Flight LAToNY = new Flight ("LAToNY");
		LAToNY = flightRepo.save(LAToNY);
		
		Flight LAToNY2 = new Flight ("LAToNY2");
		LAToNY2 = flightRepo.save(LAToNY2);
		
		
		Flight ParisToLondon = new Flight("ParisToLondon");
		ParisToLondon = flightRepo.save(ParisToLondon);
		
		Flight CairoToNairobi = new Flight("CairoToNairobi");
		CairoToNairobi = flightRepo.save(CairoToNairobi);
		
		Flight MiamiToSan = new Flight ("MiamiToSan");
		MiamiToSan = flightRepo.save(MiamiToSan);
		
		
		
		
		Passenger KamilePratt = new  Passenger("Kamile", "Pratt", 2, 1, 25);
		Passenger StanMosley = new  Passenger("Stan", "Mosley", 1, 2, 50, ParisToLondon);
		Passenger PhillippaHartley = new  Passenger("Phillippa", "Hartley", ParisToLondon);	
		KamilePratt = passengerRepo.save(KamilePratt);
		StanMosley = passengerRepo.save(StanMosley);
		PhillippaHartley = passengerRepo.save(PhillippaHartley);
		
		//ParisToLondon.add1Passenger(KamilePratt);
		ParisToLondon = flightRepo.save(ParisToLondon);
		
		
		
		Passenger PoppyMaeDavies = new  Passenger("Poppy-Mae", "Davies", 2, 1, 25, CairoToNairobi);
		PoppyMaeDavies = passengerRepo.save(PoppyMaeDavies);
		
		Passenger IzabelleLacey = new  Passenger("Izabelle", "Lacey", 2, 2, 50, CairoToNairobi);
		IzabelleLacey = passengerRepo.save(IzabelleLacey);
		
		Passenger AdnanKenny = new  Passenger("Adnan", "Kenny", CairoToNairobi);
		AdnanKenny = passengerRepo.save(AdnanKenny);
		CairoToNairobi = flightRepo.save(CairoToNairobi);
		
		
		
		
		Passenger LokiHinton = new  Passenger("Loki", "Hinton", 2, 1, 25, MiamiToSan);
		LokiHinton = passengerRepo.save(LokiHinton);
		
		Passenger PtolemyPacheco = new  Passenger("Ptolemy", "Pacheco", 2, 2, 40, MiamiToSan);
		PtolemyPacheco = passengerRepo.save(PtolemyPacheco);
		
		Passenger MarthaKirby = new  Passenger("Martha", "Kirby", MiamiToSan);
		MarthaKirby = passengerRepo.save(MarthaKirby);
		MiamiToSan = flightRepo.save(MiamiToSan);
		
		
		Passenger AdnanKenny1 = new  Passenger("Adnan1", "Kenny1", 1, 2, 50);
		AdnanKenny1 = passengerRepo.save(AdnanKenny1);
		MiamiToSan.addPassengers(AdnanKenny1);
		MiamiToSan.addPassengers(PoppyMaeDavies, IzabelleLacey, AdnanKenny );
		MiamiToSan = flightRepo.save(MiamiToSan);
		
		
		
		
		
//		LAToNY2.add1Passenger(KamilePratt);
		LAToNY2 = flightRepo.save(LAToNY2);
		
		
	}
	

	
}
