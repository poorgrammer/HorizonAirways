package com.px1.horizonairways.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightId {
	
	private String flightNo;
	private Date flightDate;
	
	public FlightId() {
	}

	public FlightId(String flightNo, Date flightDate) {
		super();
		this.flightNo = flightNo;
		this.flightDate = flightDate;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return this.flightNo + df.format(this.flightDate);
	}
	
	

}
