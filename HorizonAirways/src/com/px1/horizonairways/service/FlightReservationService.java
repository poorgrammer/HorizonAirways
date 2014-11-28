package com.px1.horizonairways.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.px1.horizonairways.daimpl.ReservationDA;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.FlightSchedule;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.PassengerSeatPlan;
import com.px1.horizonairways.entity.ReservedFlight;

public class FlightReservationService {

	private ReservationDA da;
	
	public FlightReservationService(){
		
	}

	public FlightReservationService(ReservationDA da){
		this.da = da;
	}
	
	public void setDa(ReservationDA da) {
		this.da = da;
	}
	
	public List<FlightSchedule> getAllFlightSchedule(){
		return da.getAllFlightSchedule();
	}
	
	public List<FlightDetails> getAllFlightDetailsByNumAndDate(String flightNo, Date flightDate){
		return da.getAllFlightDetailsByFlightNoAndDate(flightNo, flightDate);
	}
	
	public List<FlightDetails> getAllFlightDetailsBySector(String sectorId,Date d){
		return da.getAllFlightDetailsBySector(sectorId,d);
	}
	
	public Map<String, BigDecimal> getFlightFareBySectorId(String sectorId){
		return da.getFlightFareBySector(sectorId);
	}
	
	public FlightDetails getFlightDetailsById(FlightId id){
		return da.getFlightDetails(id);
	}
	
	public List<String> getAllOccupiedSeatsByFlight(FlightId flightId){
		return da.getAllOccupiedSeatsByFlight(flightId);
	}
	public int insertPassengerDetails(Passenger passenger){
		return da.savePassenger(passenger);
	}
	
	public int saveReservationDetails(ReservedFlight reservedFlight){
		return da.saveFlightReservation(reservedFlight);
	}
	
	public String getPassengerPNR(Passenger passenger){
		return da.getPassengerPNR(passenger);
	}
	
	public int cancelReservation(String pnr){
		return da.cancelPassengerReservation(pnr);
	}
	
	public Passenger getPassengerDetailsByPNR(String pnr){
		return da.getPassengerDetailsByPNR(pnr);

	}

	public List<ReservedFlight> getAllReservedFlights(String pnr){
		return da.getReservedFlights(pnr);
	}
	
	public PassengerSeatPlan getPassengerSeatPlanByFlightId(FlightId flightId){
		PassengerSeatPlan seatPlan =  new PassengerSeatPlan(flightId,da);
		return seatPlan;
	}
	





}
