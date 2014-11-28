package com.px1.horizonairways.daimpl;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.px1.db.DatabaseConnector;
import com.px1.horizonairways.da.FlightAircraftDA;
import com.px1.horizonairways.entity.AircraftLayout;

public class FlightDAImpl implements FlightAircraftDA {
private static final String FIND_LAYOUT_BY_FLIGHTNO = "SELECT Rows,FirstClassArrangement,BusinessClassArrangement,EconomyClassArrangement FROM VwFlightByAircraftModel WHERE FlightNo=?";
	@Override
	public AircraftLayout getLayoutByFlightNo(String flightNo) {
		PreparedStatement stat = null;
		try {
			stat =  DatabaseConnector.getConnection().prepareStatement(FIND_LAYOUT_BY_FLIGHTNO);
			stat.setString(1, flightNo);
			ResultSet rs = stat.executeQuery();
			AircraftLayout aircraftLayout= new AircraftLayout();
			while(rs.next()){
				String[] rows = rs.getString(1).split(":");
				aircraftLayout.setFirstClassRows(new Integer(rows[0]));
				aircraftLayout.setBusinessClassRows(new Integer(rows[1]));
				aircraftLayout.setEconomyClassRows(new Integer(rows[2]));
				aircraftLayout.setFirstClassSeatArrangement(rs.getString(2));
				aircraftLayout.setBusinessClassSeatArrangement(rs.getString(3));
				aircraftLayout.setEconomyClassSeatArrangement(rs.getString(4));
			}
//			System.out.println(aircraftLayout.toString());
			return aircraftLayout;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if(stat != null){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
