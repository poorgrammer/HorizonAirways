package com.px1.horizonairways.entity;

import java.util.List;

import com.px1.horizonairways.daimpl.FlightDAImpl;
import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.service.FlightReservationService;
import com.px1.horizonairways.service.FlightService;

public class PassengerSeatPlan {
private int rowCounter=1;
private List<String> occupiedSeats;
private AircraftLayout layout;
private FlightId flightId;
private FlightReservationService frs;
private FlightService fs;
private static final String FIRSTCLASS="first";
private static final String BUSINESSCLASS="business";
private static final String ECONOMYCLASS="economy";
private String firstClassHTML;
private String businessClassHTML;
private String economyClassHTML;
private String html;

	public PassengerSeatPlan(FlightId flightId,ReservationDA da) {
		this.flightId = flightId;
		fs = new FlightService(new FlightDAImpl());
		this.layout = fs.getAircraftLayout(flightId.getFlightNo());
		this.frs  =  new FlightReservationService(da);
		this.occupiedSeats  = frs.getAllOccupiedSeatsByFlight(this.flightId);
	}
	
	public FlightId getFlightId() {
		return flightId;
	}
	public void setFlightId(FlightId flightId) {
		this.flightId = flightId;
	}

	
	private void createSeatPlanHTML(){
		this.firstClassHTML = createAreaHTML(FIRSTCLASS
											, this.layout.getFirstClassRows()
											, this.layout.getFirstClassSeatArrangement());
		this.businessClassHTML = createAreaHTML(BUSINESSCLASS
											, this.layout.getBusinessClassRows()
											, this.layout.getBusinessClassSeatArrangement());
		this.economyClassHTML = createAreaHTML(ECONOMYCLASS
											, this.layout.getEconomyClassRows()
											, this.layout.getEconomyClassSeatArrangement());
		this.rowCounter = 0;
		
		this.html = new StringBuffer(this.firstClassHTML).append(this.businessClassHTML).append(this.economyClassHTML).toString();
	}
	
	public String getHTML(){
		if(this.html == null){
			createSeatPlanHTML();
		}
		return this.html;
	}
	
	
	public String getFirstClassHTML() {
		if(this.html == null){
			createSeatPlanHTML();
		}
		return this.firstClassHTML;
	}

	public String getBusinessClassHTML() {
		if(this.html == null){
			createSeatPlanHTML();
		}
		return this.businessClassHTML;
	}

	public String getEconomyClassHTML() {
		if(this.html == null){
			createSeatPlanHTML();
		}
		return this.economyClassHTML;
	}

	private String createAreaHTML(String areaClass,int numOfRows,int[] arrangement){
		StringBuffer stringHTML = new StringBuffer();
		int fcSumPerRow = 0;
		int aisleCnt = 0;
		int noOfAisle = (arrangement.length -1);
		for(int i=0;i< arrangement.length;i++){
			fcSumPerRow+=arrangement[i];
		}
		
		stringHTML.append("<table class='passengerClassArea "+areaClass+"'>");
		for(int fcRows=1; fcRows <= numOfRows;fcRows++){
			stringHTML.append("<tr>");
			char start='A';
			for(int fcCols=0;fcCols < arrangement.length;fcCols++){
					
					for(int i=0;i<arrangement[fcCols];i++){
						String seatNo = String.valueOf((char)start)+rowCounter;
						if(this.occupiedSeats.contains(seatNo)){
							stringHTML.append("<td class='occupied seat'>");
						}else{
							stringHTML.append("<td class='available seat'>");
						}
						stringHTML.append(seatNo);
						stringHTML.append("<div class='seatNo' hidden>"+seatNo+"</div>");
						stringHTML.append("<div class='seatClass' hidden>"+areaClass+"</div>");
						stringHTML.append("</td>");
							start++;
					}
					if(aisleCnt < noOfAisle){
					stringHTML.append("<td class='aisle'></td>");
					aisleCnt++;
					}
					
			}
			aisleCnt = 0;
			this.rowCounter++;
			stringHTML.append("</tr>");
		}
		stringHTML.append("</table>");
		
		return stringHTML.toString();
	}

	
}
