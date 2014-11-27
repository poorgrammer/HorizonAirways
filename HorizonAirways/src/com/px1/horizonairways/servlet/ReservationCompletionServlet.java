package com.px1.horizonairways.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReservedFlight;
import com.px1.horizonairways.service.FlightReservationService;

/**
 * Servlet implementation class ReservationCompletionServlet
 */
public class ReservationCompletionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCompletionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FlightReservationService service = new FlightReservationService();
		service.setDa(new ReservationDA());
		HttpSession session = request.getSession();
		
		Passenger passenger = (Passenger)session.getAttribute("passenger");
		FlightDetails firstFlight = (FlightDetails) session.getAttribute("firstFlight");
		service.insertPassengerDetails(passenger);
		String seatNo = (String)session.getAttribute("seatNo");
		String seatClass = (String)session.getAttribute("seatClass");
		String mealPreference = (String)session.getAttribute("mealPreference");
		String SSR = (String)session.getAttribute("SSR");
		
		String pnr = service.getPassengerPNR(passenger);
		passenger.setPnr(pnr);
		ReservedFlight reservedFlight = new ReservedFlight(passenger.getPnr(), firstFlight.getFlightNo(), firstFlight.getFlightDate(), seatNo, seatClass, mealPreference, SSR);
		int result = service.saveReservationDetails(reservedFlight);
		
		if(session.getAttribute("secondFlight")!=null){
			FlightDetails secondFlight = (FlightDetails) session.getAttribute("secondFlight");
			 reservedFlight = new ReservedFlight(passenger.getPnr(), secondFlight.getFlightNo(), secondFlight.getFlightDate(), seatNo, seatClass, mealPreference, SSR);
			service.saveReservationDetails(reservedFlight);
		}
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("./thankyou.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
