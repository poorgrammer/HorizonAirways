package com.px1.horizonairways.entity;

import java.util.Date;

public class Passenger {

	private String pnr;
	private String lastName;
	private String firstName;
	private Date birthDay;
	private String gender;
	private boolean cancelFlag;
	private String mobileNo;
	private String emailAddress;
	
	public Passenger() {
	}

	public Passenger(String pnr, String lastName, String firstName,
			Date birthDay, String gender, boolean cancelFlag, String mobileNo,
			String emailAddress) {
		super();
		this.pnr = pnr;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDay = birthDay;
		this.gender = gender;
		this.cancelFlag = cancelFlag;
		this.mobileNo = mobileNo;
		this.emailAddress = emailAddress;
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

	public boolean isCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(boolean cancelFlag) {
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
	
}
