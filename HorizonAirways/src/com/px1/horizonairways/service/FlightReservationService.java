package com.px1.horizonairways.service;

import java.util.List;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.FlightDetails;
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
	
	public List<FlightDetails> getAllFlightDetailsByNum(String flightNo){
		return da.getAllFlightDetailsByFlightNo(flightNo);
	}
}
