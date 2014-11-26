package com.px1.horizonairways.daimpl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.px1.horizonairways.da.FlightDetailsDA;
import com.px1.horizonairways.da.PassengerDetailsDA;
import com.px1.horizonairways.da.ReserveFlightsDA;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.FlightSchedule;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReserveFlights;

public class ReservationDA implements FlightDetailsDA, PassengerDetailsDA, ReserveFlightsDA {

	private static final String GET_ALL_FLIGHT_SCHEDULE = "SELECT * FROM flightdetailsindays";
	
	@Override
	public List<FlightSchedule> getAllFlightSchedule() {
		List<FlightSchedule> flightSchedList = new ArrayList<FlightSchedule>();
		Statement stat = null;
		
		return flightSchedList;
	}
	
	@Override
	public List<FlightDetails> getAllFlightDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<FlightDetails> getFlightDetails(FlightId id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Passenger> getAllPassenger() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ReserveFlights> getAllReserveFlights() {
		// TODO Auto-generated method stub
		return null;
	}

}
