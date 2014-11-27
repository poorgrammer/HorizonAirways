package com.px1.horizonairways.da;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.FlightSchedule;

public interface FlightDetailsDA {
	
	public List<FlightDetails> getAllFlightDetails();
	public FlightDetails getFlightDetails(FlightId id);
	public List<FlightSchedule> getAllFlightSchedule();
	public List<FlightDetails> getAllFlightDetailsByFlightNoAndDate(String flightNo, Date flightDate);
	public Map<String,BigDecimal> getFlightFareBySector(String sectorId);
	public List<FlightDetails> getAllFlightDetailsBySector(String sectorId, Date flightDate);

}
