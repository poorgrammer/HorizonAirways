package com.px1.horizonairways.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.px1.horizonairways.daimpl.FlightDAImpl;
import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.AircraftLayout;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.PassengerSeatPlan;
import com.px1.horizonairways.service.FlightReservationService;
import com.px1.horizonairways.service.FlightService;

/**
 * Servlet implementation class SeatPickerServlet
 */
public class SeatPickerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatPickerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flightNo = "HA876";
		String flightDate = "2015-01-16";
		FlightId flightId  = null;

		
		try {
			flightId = new FlightId(flightNo,new SimpleDateFormat("yyyy-MM-dd").parse(flightDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

//		
		FlightReservationService frs = new FlightReservationService(new ReservationDA());
		PassengerSeatPlan seatPlan = frs.getPassengerSeatPlanByFlightId(flightId);
		
		

		
		request.setAttribute("passengerSeatPlan",seatPlan);
//		request.setAttribute("businessClassZone",businessClassZone);
//		request.setAttribute("economyClassZone",economyClassZone);
		RequestDispatcher rd = request.getRequestDispatcher("./SeatPicker.jsp");
		rd.forward(request, response);
	}
	
	
	

}
