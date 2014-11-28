package com.px1.horizonairways.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.FlightSchedule;
import com.px1.horizonairways.service.FlightReservationService;

/**
 * Servlet Filter implementation class IndexFilter
 */
public class IndexFilter implements Filter {

    /**
     * Default constructor. 
     */
    public IndexFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		FlightReservationService service = new FlightReservationService();
		ReservationDA da = new ReservationDA();
		service.setDa(da);
		List<FlightSchedule> flightSchedule = service.getAllFlightSchedule();
		request.getServletContext().setAttribute("flightScheduleList", flightSchedule);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
