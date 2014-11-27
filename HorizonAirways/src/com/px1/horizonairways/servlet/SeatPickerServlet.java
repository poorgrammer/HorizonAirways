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
import com.px1.horizonairways.service.FlightReservationService;
import com.px1.horizonairways.service.FlightService;

/**
 * Servlet implementation class SeatPickerServlet
 */
public class SeatPickerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private static int rowCounter;
     private List<String> seatNos;
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
		String flightNo = "HA102";
		String flightDate = "2015-02-03";		
		FlightReservationService frs = new FlightReservationService();
		frs.setDa(new ReservationDA());
		
		try {
			seatNos = frs.getAllOccupiedSeatsByFlight(new FlightId(flightNo,new SimpleDateFormat("yyyy-MM-dd").parse(flightDate)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rowCounter = 1;
		FlightService fs = new FlightService(new FlightDAImpl());
		AircraftLayout aircraftLayout = fs.getAircraftLayout(flightNo);
//		
		System.out.println(aircraftLayout.getFirstClassRows()+","+aircraftLayout.getBusinessClassRows()+","+aircraftLayout.getEconomyClassRows());
		String firstClassZone = createClassZone("firstClassZone", aircraftLayout.getFirstClassRows(), aircraftLayout.getFirstClassSeatArrangement(),"firstClass");
		String businessClassZone = createClassZone("businessClassZone", aircraftLayout.getBusinessClassRows(), aircraftLayout.getBusinessClassSeatArrangement(),"businessClass");
		String economyClassZone = createClassZone("economyClassZone", aircraftLayout.getEconomyClassRows(), aircraftLayout.getEconomyClassSeatArrangement(),"economyClass");

		

		
		request.setAttribute("firstClassZone",firstClassZone);
		request.setAttribute("businessClassZone",businessClassZone);
		request.setAttribute("economyClassZone",economyClassZone);
		RequestDispatcher rd = request.getRequestDispatcher("./SeatPicker.jsp");
		rd.forward(request, response);
	}
	
	
	public String createClassZone(String tableId,int numOfRows,int[] arrangement,String seatClass){
		StringBuffer stringHTML = new StringBuffer();
		int fcSumPerRow = 0;
		int aisleCnt = 0;
		int noOfAisle = (arrangement.length -1);
		for(int i=0;i< arrangement.length;i++){
			fcSumPerRow+=arrangement[i];
		}
		
		stringHTML.append("<table id='"+tableId+"'>");
		for(int fcRows=1; fcRows <= numOfRows;fcRows++){
			stringHTML.append("<tr>");
			char start='A';
			for(int fcCols=0;fcCols < arrangement.length;fcCols++){
					
					for(int i=0;i<arrangement[fcCols];i++){
						String seatNo = String.valueOf((char)start)+rowCounter;
						if(seatNos.contains(seatNo)){
							stringHTML.append("<td class='occupiedSeat "+seatClass+"'>");
						}else{
							stringHTML.append("<td class='availableSeat "+seatClass+"'>");
						}
						stringHTML.append(seatNo+"</td>");
							start++;
					}
					if(aisleCnt < noOfAisle){
					stringHTML.append("<td class='aisle'></td>");
					aisleCnt++;
					}
					
			}
			aisleCnt = 0;
			rowCounter++;
			stringHTML.append("</tr>");
		}
		stringHTML.append("</table>");
		
		return stringHTML.toString();
	}

}
