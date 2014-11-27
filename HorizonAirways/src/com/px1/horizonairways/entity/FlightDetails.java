package com.px1.horizonairways.entity;

import java.io.Serializable;
import java.util.Date;

public class FlightDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String flightNo;
	private String sectorId;
	private Date flightDate;
	private String aircraftType;
	private String departureTime;
	private String arrivalTime;
	private int firstClassSeatsAvailable;
	private int businessClassSeatsAvailable;
	private int economyClassSeatsAvailable;
	
	public FlightDetails() {
	}

	public FlightDetails(String flightNo, String sectorId, Date flightDate,
			String aircraftType, String departureTime, String arrivalTime,
			int firstClassSeatsAvailable, int businessClassSeatsAvailable,
			int economyClassSeatsAvailable) {
		super();
		this.flightNo = flightNo;
		this.sectorId = sectorId;
		this.flightDate = flightDate;
		this.aircraftType = aircraftType;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.firstClassSeatsAvailable = firstClassSeatsAvailable;
		this.businessClassSeatsAvailable = businessClassSeatsAvailable;
		this.economyClassSeatsAvailable = economyClassSeatsAvailable;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getFirstClassSeatsAvailable() {
		return firstClassSeatsAvailable;
	}

	public void setFirstClassSeatsAvailable(int firstClassSeatsAvailable) {
		this.firstClassSeatsAvailable = firstClassSeatsAvailable;
	}

	public int getBusinessClassSeatsAvailable() {
		return businessClassSeatsAvailable;
	}

	public void setBusinessClassSeatsAvailable(int businessClassSeatsAvailable) {
		this.businessClassSeatsAvailable = businessClassSeatsAvailable;
	}

	public int getEconomyClassSeatsAvailable() {
		return economyClassSeatsAvailable;
	}

	public void setEconomyClassSeatsAvailable(int economyClassSeatsAvailable) {
		this.economyClassSeatsAvailable = economyClassSeatsAvailable;
	}
	
	


}

