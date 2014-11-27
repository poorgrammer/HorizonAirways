package com.px1.horizonairways.da;

import java.util.List;

import com.px1.horizonairways.entity.Passenger;

public interface PassengerDetailsDA {
	
	public List<Passenger> getAllPassengers();
	public int savePassenger(Passenger p);
	public String getPassengerPNR(Passenger p);

}
