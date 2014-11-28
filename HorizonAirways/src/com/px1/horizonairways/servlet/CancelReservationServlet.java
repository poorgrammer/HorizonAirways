package com.px1.horizonairways.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReservedFlight;
import com.px1.horizonairways.service.FlightReservationService;

/**
 * Servlet implementation class CancelReservationServlet
 */
public class CancelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CancelReservationServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightReservationService service = new FlightReservationService();
		ReservationDA da = new ReservationDA();
		service.setDa(da);
		String pnrNo = request.getParameter("pnrNo");
		System.out.println(pnrNo);
		if(request.getParameter("flightNo")!=null){
			service.cancelReservation(pnrNo);
			response.sendRedirect("./cancelcompletion.jsp");

		}
		
	else {
			Passenger passenger = service.getPassengerDetailsByPNR(pnrNo);
		
		List<ReservedFlight> reservedFlights = service.getAllReservedFlights(pnrNo);
		
		request.setAttribute("passenger", passenger);
		request.setAttribute("reservedFlights", reservedFlights);
		request.getRequestDispatcher("./cancel.jsp").forward(request, response);}
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
