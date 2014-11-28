package com.px1.horizonairways.daimpl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	private static final String GET_ALL_RESERVED_FLIGHTS_BY_PNR = "SELECT rs.pnrno, rs.flightno, rs.flightdate, rs.seatno, rs.class, rs.meal, rs.ssr FROM reservedflights rs, passenger p WHERE rs.pnrno = ? AND rs.pnrno = p.pnrno AND p.cancelFlag = '0' AND flightDate > ?";
	private static final String GET_ALL_FLIGHT_DETAILS_BY_FLIGHTNO_AND_DATE = "SELECT * FROM vwflightschedules WHERE flightNo = ? AND flightDate > ?";
	private static final String GET_FLIGHT_FARE_BY_SECTOR = "SELECT * FROM flightdetails WHERE sectorid = ?";
private static final String GET_ALL_OCCUPIED_SEATS_BY_FLIGHTID = "SELECT SeatNo FROM reservedflights WHERE FlightNo = ? AND FlightDate = ?";
	private static final String SAVE_PASSENGER_DETAILS = "INSERT INTO passenger VALUES(?,?,?,?,?,?,?,?)";
	private static final String GET_PASSENGER_PNR = "SELECT pnrno FROM passenger WHERE firstname = ? AND lastname = ? and birthdate = ? AND reservationdate = ?";
	private static final String SAVE_FLIGHT_RESERVATION = "INSERT INTO reservedflights VALUES(?,?,?,?,?,?,?)";
	private static final String CANCEL_REGISTRATION = "UPDATE passenger SET cancelflag=1 WHERE pnrNo = ?";
	private static final String GET_PASSENGER_BY_PNR = "SELECT * FROM passenger WHERE pnrno = ?";

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
			
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			date = calendar.getTime();
		ps.setDate(2, new java.sql.Date(date.getTime()));
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
	public int saveFlightReservation(ReservedFlight reservedFlight) {
		int rows = 0;
		PreparedStatement ps = null;
		try {
			ps = DatabaseConnector.getConnection().prepareStatement(SAVE_FLIGHT_RESERVATION);
			ps.setString(1, reservedFlight.getPNRNo());
			ps.setString(2, reservedFlight.getFlightNo());
			ps.setDate(3, new java.sql.Date(reservedFlight.getFlightDate().getTime()));
			ps.setString(4, reservedFlight.getSeatNo());
			ps.setString(5, reservedFlight.getSeatClass());
			ps.setString(6, reservedFlight.getMealPreference());
			ps.setString(7, reservedFlight.getSSR());
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


	@Override
	public int cancelPassengerReservation(String pnr) {

		int rows = 0;
		PreparedStatement ps = null;
		try {
			ps = DatabaseConnector.getConnection().prepareStatement(CANCEL_REGISTRATION);
			ps.setString(1, pnr);
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
		System.out.println(rows);
		return rows;
		
	}


	@Override
	public Passenger getPassengerDetailsByPNR(String pnr) {

		Passenger passenger = null;
		PreparedStatement ps = null;
		try {
			ps = DatabaseConnector.getConnection().prepareStatement(GET_PASSENGER_BY_PNR);
			ps.setString(1, pnr);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String pnrNo = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				Date birthDay = rs.getDate(4);
				String gender = rs.getString(5);
				int cancelFlag = rs.getInt(6);
				String mobileNo = rs.getString(7);
				String email = rs.getString(8);
				Date reservationDate = rs.getDate(9);	
				passenger = new Passenger(lastName, firstName, birthDay, gender, cancelFlag, mobileNo, email, reservationDate);
				passenger.setPnr(pnrNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return passenger;
		
	}





	@Override
	public List<String> getAllOccupiedSeatsByFlight(FlightId flightId) {

		
		PreparedStatement ps = null;
		List<String> occupiedSeats = new ArrayList<String>();
		try {
			ps = DatabaseConnector.getConnection().prepareStatement(
					GET_ALL_OCCUPIED_SEATS_BY_FLIGHTID);
			ps.setString(1, flightId.getFlightNo());
			ps.setDate(2, new java.sql.Date(flightId.getFlightDate().getTime()));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				occupiedSeats.add(rs.getString(1));
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

		return occupiedSeats;
	}


	@Override
	public List<Passenger> getAllPassengersByFlight(FlightId id) {
		// TODO Auto-generated method stub
		return null;
	}








}
