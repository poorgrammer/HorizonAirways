package com.px1.horizonairways.service;

import com.px1.horizonairways.daimpl.FlightDAImpl;
import com.px1.horizonairways.entity.AircraftLayout;

public class FlightService {
	FlightDAImpl da;

	public FlightService(FlightDAImpl da) {
		this.da = da;
	}

	public FlightService() {}

	public FlightDAImpl getDa() {
		return da;
	}

	public void setDa(FlightDAImpl da) {
		this.da = da;
	}
	
	public AircraftLayout getAircraftLayout(String flightNo){
		return da.getLayoutByFlightNo(flightNo);
	}
	

}
