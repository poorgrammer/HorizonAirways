package com.px1.horizonairways.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.PassengerSeatPlan;
import com.px1.horizonairways.service.FlightReservationService;

/**
 * Servlet implementation class FlightReservationDetailsServlet
 */
public class FlightReservationDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightReservationDetailsServlet() {
        super();
  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		FlightReservationService service = new FlightReservationService();
		ReservationDA da = new ReservationDA();
		service.setDa(da);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	
			try {
					Date date = format.parse(request.getParameter("firstFlight"));
					FlightId id = new FlightId(session.getAttribute("firstFlightNo").toString(),date);
					session.setAttribute("firstFlight", service.getFlightDetailsById(id));	
				
				
				PassengerSeatPlan firstPassengerSeatPlan = service.getPassengerSeatPlanByFlightId(id);
				request.setAttribute("firstPassengerSeatPlan",firstPassengerSeatPlan);
				request.setAttribute("flightId1", id);
				
				if(request.getParameter("trip").equals("roundtrip")){
				
					date =format.parse(request.getParameter("secondFlight"));
					id = new FlightId(session.getAttribute("secondFlightNo").toString(),date);
					session.setAttribute("secondFlight", service.getFlightDetailsById(id));	
					
					PassengerSeatPlan secondPassengerSeatPlan = service.getPassengerSeatPlanByFlightId(id);
					request.setAttribute("secondPassengerSeatPlan",secondPassengerSeatPlan);
					request.setAttribute("flightId2", id);
				}else{
					session.setAttribute("secondFlight", null);
					request.setAttribute("secondPassengerSeatPlan",null);
					request.setAttribute("flightId2", null);
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
	

//else {
//	
//	try {
//		Date date = format.parse(request.getParameter("firstFlight"));
//		FlightId id = new FlightId(session.getAttribute("firstFlightNo").toString(),date);
//		session.setAttribute("firstFlight", service.getFlightDetailsById(id));
//	session.setAttribute("secondFlight", null);
//	PassengerSeatPlan firstPassengerSeatPlan = service.getPassengerSeatPlanByFlightId(id);
//	request.setAttribute("firstPassengerSeatPlan",firstPassengerSeatPlan);
//	
//	
//	
//	} catch (ParseException e) {
//
//		e.printStackTrace();
//	}	
//}







if(request.getParameter("logout")!=null) {
	request.getSession().invalidate();
	request.getRequestDispatcher("./index.jsp").forward(request, response);
}

request.getRequestDispatcher("./passengerdetails.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
