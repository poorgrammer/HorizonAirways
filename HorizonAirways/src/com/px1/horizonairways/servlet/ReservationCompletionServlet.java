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
		String pnr = service.getPassengerPNR(passenger);
		passenger.setPnr(pnr);
		
		int result = service.saveReservationDetails(passenger, firstFlight);
		
		if(session.getAttribute("secondFlight")!=null){
			FlightDetails secondFlight = (FlightDetails) session.getAttribute("secondFlight");
			service.saveReservationDetails(passenger, secondFlight);
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
