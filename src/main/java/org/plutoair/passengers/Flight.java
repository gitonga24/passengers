package org.plutoair.passengers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity 
public class Flight {
	
	
	@Id
	@GeneratedValue 
	private Long id;
	
	@OneToMany(mappedBy="flight")
	private List<Passenger> passengers;
	
	
	private int passengerCount = 0;
	int seats = 150;
	private String flightName; 
	private boolean [] isSeatAvailable;
	
	int maxCarryOns = seats * 2;
	int totalCarryOns; 
	int totalCheckedBags;
	
	

	//initialization block.
	{
		isSeatAvailable = new boolean [seats];
		
		for (int i=0; i < seats; i++) {
			isSeatAvailable[i] = true;
		}
		
	}
	
	public Flight() { }
	
	public Flight(String flightName) {
		this(); //calls the default constructor 
		this.flightName = flightName; 
	}
	


	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public int getPassengerCount() {return passengerCount;}
	public void setPassengerCount(int passengerCount) {this.passengerCount = passengerCount;}
	public void setSeats(int seats) {this.seats = seats;}
	public int getSeats() {return seats;}

	public List<Passenger> getPassengers() {return passengers;}
	public void setPassenger(List<Passenger> passenger) {this.passengers = passenger;}
	

	public String getFlightName() {	return flightName;}
	public void setFlightName(String flightName) {	this.flightName = flightName;}




	public void add1Passenger() {
		if(passengerCount < seats) {
			passengerCount +=1;
			seats -=1;
		}
		else 
			handleTooMany();
	}
	
	public void add1Passenger (int bags) {
		if(hasSeating()) {
			add1Passenger();
			totalCheckedBags += bags;
		}
	}
	
	public void add1Passenger (Passenger p) {
		add1Passenger(p.getCheckedBags());
		
	}
	
	public void add1Passenger (int bags, int carryOns) {
		if(hasSeating() && hasCarryOnSpace(carryOns)) {
			add1Passenger(bags);
			totalCarryOns += carryOns;
		}
	}
	
	public void add1Passenger (Passenger p, int carryOns) {
		add1Passenger(p.getCheckedBags(), carryOns);
	}
	
	
	
	
	private void handleTooMany() {
		System.out.println("Too many Passengers");
	}
	
	public boolean hasRoom(Flight f2) {
		int total = passengerCount + f2.passengerCount;
		return total <= seats;
	}
	
	
	public Flight createNewWithBoth(Flight f2) {
		Flight newFlight = new Flight(); 
		newFlight.seats = seats + 150;
		newFlight.passengerCount = passengerCount + f2.passengerCount;
		return newFlight; 
	}
	
	
	private boolean hasSeating() {
		return passengerCount < seats;
	}
	
	private boolean hasSeating(int count) {
		return passengerCount + count < seats; 
	}
	
	
	private boolean hasCarryOnSpace(int carryOns) {
		return totalCarryOns + carryOns <= maxCarryOns;
	}
	
	
	public void addPassengers (Passenger...list) {
		if (hasSeating(list.length)) {
			List <Passenger> localPassengers = new ArrayList<>();
			for(Passenger passenger :list) {
//				this.setPassenger();
//				list.add(passenger);
				localPassengers.add(new Passenger(passenger.getFirstName(), passenger.getLastName()));		
				add1Passenger(passenger);
			}
			setPassenger(localPassengers);
//			this.passengers.add(list);
			 
		}
		else
			handleTooMany();
	}

	
	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((flightName == null) ? 0 : flightName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(isSeatAvailable);
		result = prime * result + maxCarryOns;
//		result = prime * result + ((passengerCount == null) ? 0 : passengerCount.hashCode());
		result = prime * result + passengerCount;
		result = prime * result + seats;
		result = prime * result + totalCarryOns;
		result = prime * result + totalCheckedBags;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;

		if (flightName == null) {
			if (other.flightName != null)
				return false;
		} else if (!flightName.equals(other.flightName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(isSeatAvailable, other.isSeatAvailable))
			return false;
		if (maxCarryOns != other.maxCarryOns)
			return false;
		if (passengers == null) {
			if (other.passengers != null)
				return false;
		} else if (!passengers.equals(other.passengers))
			return false;
		if (passengers != other.passengers)
			return false;
		if (seats != other.seats)
			return false;
		if (totalCarryOns != other.totalCarryOns)
			return false;
		if (totalCheckedBags != other.totalCheckedBags)
			return false;
		return true;
	}

	
	
	

	

}
