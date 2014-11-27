package com.px1.horizonairways.da;

import java.util.List;

import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReservedFlight;

public interface ReserveFlightsDA {
	
	public List<ReservedFlight> getAllReservedFlights();
	public List<ReservedFlight> getReservedFlights(String pnr);
	public List<Passenger> getAllPassengersByFlight(FlightId id);
	public int saveFlightReservation(Passenger passenger, FlightDetails flightDetails);

}
