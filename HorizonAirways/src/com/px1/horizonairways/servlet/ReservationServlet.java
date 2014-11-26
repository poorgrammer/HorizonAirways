package com.px1.horizonairways.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.service.FlightReservationService;

/**
 * Servlet implementation class ReservationServlet
 */
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flightNo = request.getParameter("flightNo");
		String sectorId = request.getParameter("sectorId");
		BigDecimal firstClassFare = new BigDecimal(request.getParameter("firstClassFare"));
		BigDecimal businessClassFare = new BigDecimal(request.getParameter("businessClassFare"));
		BigDecimal economyClassFare = new BigDecimal(request.getParameter("economyClassFare"));
		
		FlightReservationService service = new FlightReservationService();
		ReservationDA da = new ReservationDA();
		service.setDa(da);
		List<FlightDetails> flightDetailsList = service.getAllFlightDetailsByNum(flightNo);
		request.setAttribute("flightDetailsList", flightDetailsList);
		
		request.setAttribute("flightNo", flightNo);
		request.setAttribute("firstClassFare", firstClassFare);
		request.setAttribute("businessClassFare", businessClassFare);
		request.setAttribute("economyClassFare", economyClassFare);
		request.setAttribute("sectorId", sectorId);
		request.getRequestDispatcher("reservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
