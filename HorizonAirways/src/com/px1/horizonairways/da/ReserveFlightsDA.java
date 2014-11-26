package com.px1.horizonairways.da;

import java.util.List;

import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReserveFlight;

public interface ReserveFlightsDA {
	
	public List<ReserveFlight> getAllReserveFlights();
	public List<ReserveFlight> getReserveFlights(String pnr);
	public List<Passenger> getAllPassengersByFlight(FlightId id);

}
