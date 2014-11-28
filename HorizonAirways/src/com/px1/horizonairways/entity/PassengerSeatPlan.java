package com.px1.horizonairways.entity;

import java.util.List;

import com.px1.horizonairways.daimpl.FlightDAImpl;
import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.service.FlightReservationService;
import com.px1.horizonairways.service.FlightService;

public class PassengerSeatPlan {
private static int rowCounter=1;
private List<String> occupiedSeats;
private AircraftLayout layout;
private FlightId flightId;
private FlightReservationService frs;
private FlightService fs;

	public PassengerSeatPlan(FlightId flightId) {
		this.flightId = flightId;
		fs = new FlightService(new FlightDAImpl());
		this.layout = fs.getAircraftLayout(flightId.getFlightNo());
		frs = new FlightReservationService(new ReservationDA());
		this.occupiedSeats = frs.getAllOccupiedSeatsByFlight(flightId);
	}
	public FlightId getFlightId() {
		return flightId;
	}
	public void setFlightId(FlightId flightId) {
		this.flightId = flightId;
	}
	
	

	
}
