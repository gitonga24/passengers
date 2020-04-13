package org.plutoair.passengers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Passenger {	
	
	
	@Id
	@GeneratedValue 
	private Long id;
	
	@GeneratedValue
	private int ticketNumber; 
	
	
	
	@ManyToOne
	private Flight flight;
	
	
	private String firstName;
	private String lastName;
	private int checkedBags;
	private int freeBags;
	private double perBagFee;
	

	public Long getId() {return id;	}
	public void setId(Long id) {this.id = id;}
	public String getLastName() {return lastName;}
	public void setLastName( String lastName) {this.lastName = lastName;}
	public String getFirstName() {return firstName;}
	public void setFirstName( String firstName) {this.lastName = firstName;}
	public int getCheckedBags() {	return checkedBags;}
	public void setCheckedBags(int checkedBags) {	this.checkedBags = checkedBags;}
	public int getFreeBags() {	return freeBags;}
	public void setFreeBags(int freeBags) {	this.freeBags = freeBags;}
	public double getPerBagFee() {	return perBagFee;}
	public void setPerBagFee(double perBagFee) {	this.perBagFee = perBagFee;}
	
	
	
	public Passenger() {}
	
	public Passenger(String firstName, String lastName, int checkedBags, int freeBags, int perBagFee, Flight flight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.checkedBags = checkedBags;
		this.freeBags = freeBags;
		this.perBagFee = perBagFee;
		this.flight = flight;
		flight.add1Passenger();
	}
	
	
	public Passenger(String firstName, String lastName, int checkedBags, int freeBags, int perBagFee) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.checkedBags = checkedBags;
		this.freeBags = freeBags;
		this.perBagFee = perBagFee;
	}
	
	
	
	public Passenger(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public Passenger(String firstName, String lastName, Flight flight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.flight = flight;
		flight.add1Passenger();
		
	}
	

	
	
	public String getFlightName() {
		if(this.flight != null)
			return flight.getFlightName();
		
		else return null;
		
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Passenger [id=" + id + ", passengerName=" + firstName + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + checkedBags;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + freeBags;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(perBagFee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ticketNumber;
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
		Passenger other = (Passenger) obj;
//		if (checkedBags != other.checkedBags)
//			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (freeBags != other.freeBags)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(perBagFee) != Double.doubleToLongBits(other.perBagFee))
			return false;
		if (ticketNumber != other.ticketNumber)
			return false;
		return true;
	}
	
	
	
	
	


	
	
	
}
