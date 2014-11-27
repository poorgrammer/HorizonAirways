<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.px1.horizonairways.da.FlightDetailsDA"%>
<%@page import="com.px1.horizonairways.entity.FlightSchedule"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.math.BigDecimal" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/reservation.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Make Reservation</title>
</head>

<body>
<font face="Arial, Helvetica, sans-serif" size="-1">

    
    <h1>Horizon Airways</h1>
    <div>
			<c:choose>
				<c:when test="${ empty sessionScope.user}">
					<form action="./login" method="post">
						<table>
							<tr>
								<td>User Name</td>
								<td><input type="text" name="userName" /></td>
								<td>Password</td>
								<td><input type="password" name="password" /></td>
								<td><input type="submit" name="submit" value="Log in" /></td>
							</tr>
						</table>
					</form>
				</c:when>
				<c:otherwise>
					<form>
						<input type="submit" name="logout" value="Log out" align="right"/>
					</form>
				</c:otherwise>
			</c:choose>
			</div>
    <hr/>

	<form action="./flightdetails" method="post">
    <table>
      <tr>


        <td width="250">
        
        <div id="totalCost" style="margin-bottom:10px"><h2>Total Cost: <span id="totalcost"> $ <c:out value="${flightFareMap.values.get(0)}"></c:out></span></h2></div><br/><br/>
      
   <select name="firstFlightfare">
      		    <c:forEach items="${sessionScope.flightFareMap}" var="flightFare">
		 			 <option value="${flightFare.key}">${flightFare.key}</option>
		 		 </c:forEach>
			  </select>
      
    
        <td width="250" class="filterArea">

        	<br/>
            <div>
           <input type="radio" name="trip" value="oneway" checked id="onewayButton"/> <label for="onewayButton"> One-Way</label> 
             <input type="radio" name="trip" value="roundtrip" id="roundtripButton"/>   <label for="roundtripButton"> RoundTrip</label>
      	  </div>    


            
            <br/><br/>
            <b>Flight Date:</b>

            <br/><br/>
       
        <select name="month">
             <c:forEach items="${months}" var="monthyear">
             <option><c:out value="${monthyear}"/></option>
               </c:forEach>
            <br/><br/>

            <br/>


    	</td>
        
        <td>
        	<h3>Flight 1</h3>
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
               <td><input type="radio" name="firstFlight" checked  value="${flightDetails.flightDate}"/></td> 
             </tr>
             </c:forEach>
           </table> 
        </td>
      </tr>
    </table>
    
    <div id="roundtrip">
    <br />
    <hr />
      <table>
      <tr>

        <td width="250">
      
          
          
          
            <select name="secondFlightfare">
      		    <c:forEach items="${sessionScope.flightFareMap}" var="flightFare">
		 			 <option value="${flightFare.key}">${flightFare.key}</option>
		 		 </c:forEach>
			  </select>
          
            <br/>

        <td width="250" class="filterArea">

 

            <b>Flight Date:</b>
            <br/>
            
       		<select name="month">
            	<c:forEach items="${months}" var="monthyear">
             		<option><c:out value="${monthyear}"/></option>>
            	</c:forEach>
            </select>
            
            <input type="submit" name="submit" value="Search" align="right"/>
    	</td>
        
        <td>
        	<h3>Flight 2</h3>
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
             
             <c:forEach items="${flightDetailsRoundtrip}" var="flightDetailsRoundtrip">
             <tr>
               <td>${flightDetailsRoundtrip.flightNo}</td>
               <td>${flightDetailsRoundtrip.sectorId}</td>
               <td>${flightDetailsRoundtrip.flightDate}</td>
               <td>${flightDetailsRoundtrip.aircraftType}</td>
               <td>${flightDetailsRoundtrip.departureTime}</td>
               <td>${flightDetailsRoundtrip.arrivalTime}</td>
               <td>${flightDetailsRoundtrip.firstClassSeatsAvailable}</td>
               <td>${flightDetailsRoundtrip.businessClassSeatsAvailable}</td>
               <td>${flightDetailsRoundtrip.economyClassSeatsAvailable}</td>
                 <td><input type="radio" name="secondFlight"  checked value="${flightDetailsRoundtrip.flightDate}"/></td> 
             </tr>
             </c:forEach>
           </table> 
        </td>
      </tr>
    </table>
    
    </div>
    
    

<input type="submit" value="Reserve the flight!"></input>
</form>
</font>
<script src="js/reservation.js"></script>
</body>
</html>
