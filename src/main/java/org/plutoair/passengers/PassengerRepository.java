package org.plutoair.passengers;

import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {

	Passenger findByLastName (String lastName);
}
