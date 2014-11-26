package com.px1.horizonairways.daimpl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	private static final String GET_ALL_FLIGHT_SCHEDULE = "SELECT * FROM flightdetailsindays";
	private static final String GET_ALL_FLIGHT_DETAILS = "SELECT * FROM flightdetails";
	private static final String GET_ALL_FLIGHT_DETAILS_BY_FLIGHTID = "SELECT * FROM flightdetails WHERE FlightNo = ? AND FlightDate = ?";
	private static final String GET_ALL_RESERVED_FLIGHTS_BY_PNR = "SELECT * FROM reservedflights WHERE pnrno = ?";

	@Override
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
				BigDecimal firstClassFare = rs.getBigDecimal(8);
				BigDecimal businessClassFare = rs.getBigDecimal(9);
				BigDecimal economyClassFare = rs.getBigDecimal(10);

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

	@Override
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

	@Override
	public List<FlightDetails> getFlightDetails(FlightId flightId) {

		List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();

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

				FlightDetails flightDetails = new FlightDetails(flightNo,
						sectorId, flightDate, aircraftDescription, depTime,
						arrTime, firstClassFare, businessClassFare,
						economyClassFare);

				flightDetailsList.add(flightDetails);

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

		return flightDetailsList;

	}

	@Override
	public List<Passenger> getAllPassengers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservedFlight> getAllReservedFlights() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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

	
	
	@Override
	public List<Passenger> getAllPassengersByFlight(FlightId id) {
		
		
		
		return null;
	}

}
