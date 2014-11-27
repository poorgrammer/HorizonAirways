package com.px1.horizonairways.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class FlightSchedule  implements Serializable{
	
	private String flightNo;
	private String sectorId;
	private String day;
	private String aircraftType;
	private String departureTime;
	private String arrivalTime;
	private BigDecimal firstClassFare;
	private BigDecimal businessClassFare;
	private BigDecimal economyClassFare;
	
	public FlightSchedule() {
	}

	public FlightSchedule(String flightNo, String sectorId, String day,
			String aircraftType, String departureTime, String arrivalTime,
			BigDecimal firstClassFare, BigDecimal businessClassFare,
			BigDecimal economyClassFare) {
		super();
		this.flightNo = flightNo;
		this.sectorId = sectorId;
		this.day = day;
		this.aircraftType = aircraftType;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.firstClassFare = firstClassFare;
		this.businessClassFare = businessClassFare;
		this.economyClassFare = economyClassFare;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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

	public BigDecimal getFirstClassFare() {
		return firstClassFare;
	}

	public void setFirstClassFare(BigDecimal firstClassFare) {
		this.firstClassFare = firstClassFare;
	}

	public BigDecimal getBusinessClassFare() {
		return businessClassFare;
	}

	public void setBusinessClassFare(BigDecimal businessClassFare) {
		this.businessClassFare = businessClassFare;
	}

	public BigDecimal getEconomyClassFare() {
		return economyClassFare;
	}

	public void setEconomyClassFare(BigDecimal economyClassFare) {
		this.economyClassFare = economyClassFare;
	}
	

}

