package com.px1.horizonairways.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.User;
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
		Date date = new Date();
		Calendar calendar = new GregorianCalendar(/* remember about timezone! */);
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 30);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		
		List<FlightDetails> flightDetailsList = service.getAllFlightDetailsByNumAndDate(flightNo,date);
		
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		
		String roundtripSector = sectorId.substring(3) + sectorId.charAt(2) + sectorId.substring(0,2);
		List<FlightDetails> flightDetailsRoundtrip = service.getAllFlightDetailsBySector(roundtripSector,date);
		
		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		List<String> months = new ArrayList<String>();
	    calendar = Calendar.getInstance();
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

		request.getSession().setAttribute("flightDetailsList", flightDetailsList);
		request.getSession().setAttribute("flightDetailsRoundtrip", flightDetailsRoundtrip);
		
		request.getSession().setAttribute("firstFlightNo",flightDetailsList.get(0).getFlightNo());
		request.getSession().setAttribute("secondFlightNo",flightDetailsRoundtrip.get(0).getFlightNo());
	
		request.getSession().setAttribute("months", months);
		if(request.getParameter("logout")!=null) {
		}
		request.getRequestDispatcher("reservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
