package com.px1.horizonairways.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.px1.horizonairways.entity.Passenger;

/**
 * Servlet implementation class PassengerDetailsServlet
 */
public class PassengerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender =	request.getParameter("gender");
		String bday = request.getParameter("birthDay");
		Date birthDay = null;
		try {
			birthDay = new SimpleDateFormat("yyyy-mm-dd").parse(bday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String mobileNo = request.getParameter("mobileNo");
		String emailAddress = request.getParameter("emailAddress");
		
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		
		Passenger passenger = new Passenger(lastName, firstName, birthDay, gender, 0, mobileNo, emailAddress, date);
		request.getSession().setAttribute("passenger", passenger);
		request.getRequestDispatcher("/reservationCompletion").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
