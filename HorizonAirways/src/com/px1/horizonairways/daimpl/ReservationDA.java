package com.px1.horizonairways.daimpl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.px1.db.DatabaseConnector;
import com.px1.horizonairways.da.FlightDetailsDA;
import com.px1.horizonairways.da.PassengerDetailsDA;
import com.px1.horizonairways.da.ReserveFlightsDA;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.FlightSchedule;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReservedFlight;

public class ReservationDA implements FlightDetailsDA, PassengerDetailsDA,
		ReserveFlightsDA {

	private static final String GET_ALL_FLIGHT_SCHEDULE = "SELECT DISTINCT * FROM flightdetailsindays";
	private static final String GET_ALL_FLIGHT_DETAILS = "SELECT * FROM flightschedules ";
	private static final String GET_ALL_FLIGHT_DETAILS_BY_SECTOR = "SELECT * FROM vwflightschedules WHERE sectorid = ? AND FlightDate > ?";
	private static final String GET_ALL_FLIGHT_DETAILS_BY_FLIGHTID = "SELECT * FROM flightdetails WHERE FlightNo = ? AND FlightDate = ?";
	private static final String GET_ALL_RESERVED_FLIGHTS_BY_PNR = "SELECT * FROM reservedflights WHERE pnrno = ?";
	private static final String GET_ALL_FLIGHT_DETAILS_BY_FLIGHTNO_AND_DATE = "SELECT * FROM vwflightschedules WHERE flightNo = ? AND flightDate > ?";
	private static final String GET_FLIGHT_FARE_BY_SECTOR = "SELECT * FROM flightdetails WHERE sectorid = ?";
	private static final String SAVE_PASSENGER_DETAILS = "INSERT INTO passenger VALUES(?,?,?,?,?,?,?,?)";
	private static final String GET_PASSENGER_PNR = "SELECT pnrno FROM passenger WHERE firstname = ? AND lastname = ? and birthdate = ? AND reservationdate = ?";
	private static final String SAVE_FLIGHT_RESERVATION = "INSERT INTO reservedflights VALUES(?,?,?,?,?,?,?)";
	
	public List<FlightSchedule> getAllFlightSchedule() {

		List<FlightSchedule> flightScheduleList = new ArrayList<FlightSchedule>();
		Statement stat = null;
		try {
			stat = DatabaseConnector.getConnection().createStatement();
			ResultSet rs = stat.executeQuery(GET_ALL_FLIGHT_SCHEDULE);

			while (rs.next()) {

				String flightNo = rs.getString(1);
				String sectorId = rs.getString(2);
				String weekDayOne = rs.getString(3);
				String weekDayTwo = rs.getString(4);
				String aircraftDescription = rs.getString(5);
				String depTime = rs.getString(6);
				String arrTime = rs.getString(7);
				BigDecimal firstClassFare = rs.getBigDecimal(8).setScale(2,BigDecimal.ROUND_HALF_UP);
				BigDecimal businessClassFare = rs.getBigDecimal(9).setScale(2,BigDecimal.ROUND_HALF_UP);
				BigDecimal economyClassFare = rs.getBigDecimal(10).setScale(2,BigDecimal.ROUND_HALF_UP);

				FlightSchedule flightSchedule = new FlightSchedule(flightNo,
						sectorId, weekDayOne + "/" + weekDayTwo,
						aircraftDescription, depTime, arrTime, firstClassFare,
						businessClassFare, economyClassFare);

				flightScheduleList.add(flightSchedule);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stat != null)
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return flightScheduleList;

	}

	
	public List<FlightDetails> getAllFlightDetails() {
		List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();
		Statement stat = null;
		try {
			stat = DatabaseConnector.getConnection().createStatement();
			ResultSet rs = stat.executeQuery(GET_ALL_FLIGHT_DETAILS);

			while (rs.next()) {

				String flightNo = rs.getString(1);
				String sectorId = rs.getString(2);
				String aircraftDescription = rs.getString(3);
				Date flightDate = rs.getDate(4);
				String depTime = rs.getString(5);
				String arrTime = rs.getString(6);
				int firstClassSeatsAvailable = rs.getInt(7);
				int businessClassSeatsAvailable = rs.getInt(8);
				int economyClassSeatsAvailable = rs.getInt(9);

				FlightDetails flightDetails = new FlightDetails(flightNo,
						sectorId, flightDate, aircraftDescription, depTime,
						arrTime, firstClassSeatsAvailable,
						businessClassSeatsAvailable, economyClassSeatsAvailable);

				flightDetailsList.add(flightDetails);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (stat != null)

				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return flightDetailsList;

	}

	public FlightDetails getFlightDetails(FlightId flightId) {

		FlightDetails flightDetails = null;
		PreparedStatement ps = null;
		try {
			ps = DatabaseConnector.getConnection().prepareStatement(
					GET_ALL_FLIGHT_DETAILS_BY_FLIGHTID);
			ps.setString(1, flightId.getFlightNo());
			ps.setDate(2, new java.sql.Date(flightId.getFlightDate().getTime()));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String flightNo = rs.getString(1);
				String sectorId = rs.getString(2);
				String aircraftDescription = rs.getString(3);
				Date flightDate = rs.getDate(4);
				String depTime = rs.getString(5);
				String arrTime = rs.getString(6);
				int firstClassFare = rs.getInt(7);
				int businessClassFare = rs.getInt(8);
				int economyClassFare = rs.getInt(9);

				 flightDetails = new FlightDetails(flightNo,
						sectorId, flightDate, aircraftDescription, depTime,
						arrTime, firstClassFare, businessClassFare,
						economyClassFare);

		

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (ps != null) {

				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return flightDetails;

	}

	
	public List<Passenger> getAllPassengers() {
		return null;
	}

	
	public List<ReservedFlight> getAllReservedFlights() {
		return null;
	}

	
	public List<ReservedFlight> getReservedFlights(String pnr) {

		List<ReservedFlight> reservedFlights = new ArrayList<ReservedFlight>();
		PreparedStatement ps = null;

		try {
			ps = DatabaseConnector.getConnection().prepareStatement(
					GET_ALL_RESERVED_FLIGHTS_BY_PNR);
			ps.setString(1, pnr);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				String PNRno = rs.getString(1);
				String FlightNo = rs.getString(2);
				Date flightDate = rs.getDate(3);
				String seatNo = rs.getString(4);
				String seatClass = rs.getString(5);
				String mealPreference = rs.getString(6);
				String SSR = rs.getString(7);

				ReservedFlight reservedFlight = new ReservedFlight(PNRno,
						FlightNo, flightDate, seatNo, seatClass,
						mealPreference, SSR);
				reservedFlights.add(reservedFlight);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		return reservedFlights;

	}

	
	
	
	public List<Passenger> getAllPassengersByFlight(FlightId id) {
		
		
		
		return null;
	}

	
	public List<FlightDetails> getAllFlightDetailsByFlightNoAndDate(String flightNum, Date date) {
		
		List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();
		PreparedStatement stat = null;
		try {
			stat = DatabaseConnector.getConnection().prepareStatement(GET_ALL_FLIGHT_DETAILS_BY_FLIGHTNO_AND_DATE);
			stat.setString(1, flightNum);
			stat.setDate(2, new java.sql.Date(date.getTime()));
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {

				String flightNo = rs.getString(1);
				String sectorId = rs.getString(2);
				String aircraftDescription = rs.getString(3);
				Date flightDate = rs.getDate(4);
				String depTime = rs.getString(5);
				String arrTime = rs.getString(6);
				int firstClassFare = rs.getInt(7);
				int businessClassFare = rs.getInt(8);
				int economyClassFare = rs.getInt(9);

				FlightDetails flightDetails = new FlightDetails(flightNo,
						sectorId, flightDate, aircraftDescription, depTime,
						arrTime, firstClassFare, businessClassFare,
						economyClassFare);

				flightDetailsList.add(flightDetails);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stat != null)
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return flightDetailsList;
	}




	public Map<String, BigDecimal> getFlightFareBySector(String sectorId) {
		
		Map<String, BigDecimal> flightFareMap = new HashMap<String, BigDecimal>();
		PreparedStatement stat = null;
		try {
			stat = DatabaseConnector.getConnection().prepareStatement(GET_FLIGHT_FARE_BY_SECTOR);
			stat.setString(1, sectorId);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
		BigDecimal firstClassFare = rs.getBigDecimal(7).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal businessClassFare = rs.getBigDecimal(8).setScale(2,BigDecimal.ROUND_HALF_UP);
		BigDecimal economyClassFare = rs.getBigDecimal(9).setScale(2,BigDecimal.ROUND_HALF_UP);
		
		flightFareMap.put("First Class - $" + firstClassFare, firstClassFare);
		flightFareMap.put("Business Class - $" + businessClassFare, businessClassFare);
		flightFareMap.put("Economy Class - $" + economyClassFare, economyClassFare);
		
	}
			
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if (stat != null)
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	
		}
		
		return flightFareMap;
			
			
	}


	public List<FlightDetails> getAllFlightDetailsBySector(String sector,Date date) {
		
		List<FlightDetails> flightDetailsListBySector = new ArrayList<FlightDetails>();
		PreparedStatement stat = null;
		try {
			stat = DatabaseConnector.getConnection().prepareStatement(GET_ALL_FLIGHT_DETAILS_BY_SECTOR);
			stat.setString(1, sector);
			stat.setDate(2, new java.sql.Date(date.getTime()));
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {

				String flightNo = rs.getString(1);
				String sectorId = rs.getString(2);
				String aircraftDescription = rs.getString(3);
				Date flightDate = rs.getDate(4);
				String depTime = rs.getString(5);
				String arrTime = rs.getString(6);
				int firstClassSeatsAvailable = rs.getInt(7);
				int businessClassSeatsAvailable = rs.getInt(8);
				int economyClassSeatsAvailable = rs.getInt(9);

				FlightDetails flightDetails = new FlightDetails(flightNo,
						sectorId, flightDate, aircraftDescription, depTime,
						arrTime, firstClassSeatsAvailable,
						businessClassSeatsAvailable, economyClassSeatsAvailable);

				flightDetailsListBySector.add(flightDetails);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (stat != null)

				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return flightDetailsListBySector;

	}


	@Override
	public int savePassenger(Passenger p) {

		int rows = 0;
		PreparedStatement ps = null;
		try {
			 ps = DatabaseConnector.getConnection().prepareStatement(SAVE_PASSENGER_DETAILS);
			ps.setString(1, p.getFirstName());
			ps.setString(2, p.getLastName());
			ps.setDate(3, new java.sql.Date(p.getBirthDay().getTime()));
			ps.setString(4, p.getGender());
			ps.setInt(5, p.isCancelFlag());
			ps.setString(6, p.getMobileNo());
			ps.setString(7, p.getEmailAddress());
			ps.setDate(8, new java.sql.Date(p.getReservationDate().getTime()));
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
		return rows;
	}


	@Override
	public String getPassengerPNR(Passenger p) {
		String pnr;
		
			pnr = null;
			PreparedStatement ps = null;
			try {	ps = DatabaseConnector.getConnection().prepareStatement(GET_PASSENGER_PNR);
			ps.setString(1, p.getFirstName());
			ps.setString(2, p.getLastName());
			ps.setDate(3, new java.sql.Date(p.getBirthDay().getTime()));
			ps.setDate(4, new java.sql.Date(p.getReservationDate().getTime()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				pnr = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return pnr;
	}


	@Override
	public int saveFlightReservation(Passenger passenger,
			FlightDetails flightDetails) {
		int rows = 0;
		PreparedStatement ps = null;
		try {
			ps = DatabaseConnector.getConnection().prepareStatement(SAVE_FLIGHT_RESERVATION);
			ps.setString(1, passenger.getPnr());
			ps.setString(2, flightDetails.getFlightNo());
			ps.setDate(3, new java.sql.Date(flightDetails.getFlightDate().getTime()));
			ps.setString(4, passenger.getSeatNo());
			ps.setString(5, passenger.getSeatClass());
			ps.setString(6, passenger.getMeal());
			ps.setString(7, passenger.getSSR());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return rows;
	}








}
