package com.px1.horizonairways.entity;

import java.util.Date;

public class Passenger {

	private String pnr;
	private String lastName;
	private String firstName;
	private Date birthDay;
	private String gender;
	private int cancelFlag;
	private String mobileNo;
	private String emailAddress;
	private Date reservationDate;
	private String seatNo;
	private String seatClass;
	private String meal;
	private String SSR;

	public Passenger() {
	}

	public Passenger(String lastName, String firstName,
			Date birthDay, String gender, int cancelFlag, String mobileNo,
			String emailAddress, Date reservationDate, String seatNo, String seatClass, String meal,String SSR) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDay = birthDay;
		this.gender = gender;
		this.cancelFlag = cancelFlag;
		this.mobileNo = mobileNo;
		this.emailAddress = emailAddress;
		this.reservationDate = reservationDate;
		this.seatNo = seatNo;
		this.seatClass = seatClass;
		this.meal = meal;
		this.SSR = SSR;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int isCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
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

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getSSR() {
		return SSR;
	}

	public void setSSR(String sSR) {
		SSR = sSR;
	}

	
	
	
	
}
