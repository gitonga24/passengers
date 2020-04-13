package org.plutoair.passengers;

import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {

	Flight findByFlightName (String flightName);
}
