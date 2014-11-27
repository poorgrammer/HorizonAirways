package com.px1.horizonairways.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.FlightSchedule;

public class FlightReservationService {

	private ReservationDA da;
	
	public FlightReservationService(){
		
	}

	public void setDa(ReservationDA da) {
		this.da = da;
	}
	
	public List<FlightSchedule> getAllFlightSchedule(){
		return da.getAllFlightSchedule();
		
	}
	
	public List<FlightDetails> getAllFlightDetailsByNumAndDate(String flightNo, Date flightDate){
		return da.getAllFlightDetailsByFlightNoAndDate(flightNo, flightDate);
	}
	
	public List<FlightDetails> getAllFlightDetailsBySector(String sectorId,Date d){
		return da.getAllFlightDetailsBySector(sectorId,d);
	}
	
	public Map<String, BigDecimal> getFlightFareBySectorId(String sectorId){
		return da.getFlightFareBySector(sectorId);
	}
	
	public FlightDetails getFlightDetailsById(FlightId id){
		return da.getFlightDetails(id);
	}
}
