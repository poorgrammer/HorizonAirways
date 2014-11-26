package com.px1.horizonairways.entity;

import java.util.Date;

public class ReserveFlight {
	
	private String PNRNo;
	private String FlightNo;
	private Date flightDate;
	private String seatNo;
	private String seatClass;
	private String mealPreference;
	private String SSR;
	
	public ReserveFlight() {
	}

	public ReserveFlight(String pNRNo, String flightNo, Date flightDate,
			String seatNo, String seatClass, String mealPreference, String sSR) {
		super();
		PNRNo = pNRNo;
		FlightNo = flightNo;
		this.flightDate = flightDate;
		this.seatNo = seatNo;
		this.seatClass = seatClass;
		this.mealPreference = mealPreference;
		SSR = sSR;
	}

	public String getPNRNo() {
		return PNRNo;
	}

	public void setPNRNo(String pNRNo) {
		PNRNo = pNRNo;
	}

	public String getFlightNo() {
		return FlightNo;
	}

	public void setFlightNo(String flightNo) {
		FlightNo = flightNo;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public String getMealPreference() {
		return mealPreference;
	}

	public void setMealPreference(String mealPreference) {
		this.mealPreference = mealPreference;
	}

	public String getSSR() {
		return SSR;
	}

	public void setSSR(String sSR) {
		SSR = sSR;
	}
	
	

}
