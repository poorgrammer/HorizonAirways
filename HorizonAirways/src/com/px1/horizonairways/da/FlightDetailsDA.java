package com.px1.horizonairways.da;

import java.util.List;

import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.FlightSchedule;

public interface FlightDetailsDA {
	
	public List<FlightDetails> getAllFlightDetails();
	public List<FlightDetails> getFlightDetails(FlightId id);
	public List<FlightSchedule> getAllFlightSchedule();

}
