<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.px1.horizonairways.da.FlightDetailsDA"%>
<%@page import="com.px1.horizonairways.entity.FlightSchedule"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Make Reservation</title>
</head>

<body>
<font face="Arial, Helvetica, sans-serif" size="-1">

    <br/>
    <h1>Horizon Airways</h1>
    
    <hr/>
    <br/><br/>

    <form>
    	
      <h3>Flight No: ${flightNo}</h3>
      
        <b>Flight Date:</b>
        <input type="date" name="flightDate" />
        <input type="submit" name="submit" value="Filter"/>
        
      
        
    </form>
	
    <br/>
    
<table border="1" align="center">
     <tr>
       <th rowspan="2" scope="col">Flight No.</th>
       <th rowspan="2" scope="col">Sector</th>
       <th rowspan="2" scope="col">Flight Date</th>
       <th rowspan="2" scope="col">Aircraft Type</th>
       <th rowspan="2" scope="col">Departure Time</th>
       <th rowspan="2" scope="col">Arrival Time</th>
       <th colspan="3" scope="col">Remaining Seats</th>
     </tr>
     <tr>
       <th scope="col">First Class</th>
       <th scope="col">Business Class</th>
       <th scope="col">Economy Class</th>
     </tr>
     
     <c:forEach items="${flightDetailsList}" var="flightDetails">
     <tr>
       <td>${flightDetails.flightNo}</td>
       <td>${flightDetails.sectorId}</td>
       <td>${flightDetails.flightDate}</td>
       <td>${flightDetails.aircraftType}</td>
       <td>${flightDetails.departureTime}</td>
       <td>${flightDetails.arrivalTime}</td>
       <td>${flightDetails.firstClassSeatsAvailable}</td>
       <td>${flightDetails.businessClassSeatsAvailable}</td>
       <td>${flightDetails.economyClassSeatsAvailable}</td>
     </tr>
     </c:forEach>
   </table> 
   
   
 
 
 
 
					
					
				
 
 
 
 
 
</font>
</body>
</html>
