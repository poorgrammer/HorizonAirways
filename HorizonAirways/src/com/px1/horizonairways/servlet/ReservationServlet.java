package com.px1.horizonairways.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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
	
		
		FlightReservationService service = new FlightReservationService();
		ReservationDA da = new ReservationDA();
		service.setDa(da);
		Map<String, BigDecimal> flightFareMap = service.getFlightFareBySectorId(sectorId);
		List<FlightDetails> flightDetailsList = service.getAllFlightDetailsByNum(flightNo);
		request.setAttribute("flightDetailsList", flightDetailsList);
		
		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    List<String> months = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		for(int i = 0; i<4; i++){
			int month = calendar.get(Calendar.MONTH)+i;
			int year = calendar.get(Calendar.YEAR);
			if(month/12 == 0){
				months.add(monthNames[month] + "-" + year);
			}
			
			else{
				months.add(monthNames[month%12] + "-" + (year+1));
			}
			
		}
		
		request.setAttribute("flightNo", flightNo);
		request.setAttribute("flightFareMap", flightFareMap);
		request.setAttribute("sectorId", sectorId);
		request.getSession().setAttribute("months", months);
		request.getRequestDispatcher("reservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
