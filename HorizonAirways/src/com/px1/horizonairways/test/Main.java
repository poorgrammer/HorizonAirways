package com.px1.horizonairways.test;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.ReservedFlight;

public class Main {

	public static void main(String[] args) {
		
		ReservationDA da = new ReservationDA();
		
			System.out.println( da.getAllFlightDetails().get(0).getBusinessClassSeatsAvailable());
		
		

	}

}
