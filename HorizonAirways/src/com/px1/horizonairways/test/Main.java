package com.px1.horizonairways.test;

import java.util.Date;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.Passenger;

public class Main {

	public static void main(String[] args) {
		
		ReservationDA da = new ReservationDA();

		

			Passenger p = new Passenger("1", "asda",  "asda", new Date(), "M", 0, "12343243",  "asda", new Date());

		
	System.out.println(da.getPassengerPNR(p));

	}

}
