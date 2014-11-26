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
<title>Welcome to Horizon Airways</title>
</head>

<body>
<font face="Arial, Helvetica, sans-serif" size="-1">
	<!-- LOGIN FORM -->
   	  <form action="./login" method="post">
        	<table align="right">
            	<tr>
               	  <td>User Name</td>
                  <td><input type="text" name="userName" /></td>
                  <td>Password</td>
                  <td><input type="password" name="password" /></td>
                    <td><input type="submit" name="submit" value="Log in"/></td>
                </tr>
            </table>
	</form>

    <br/><br/><br/>
    <h1>Horizon Airways</h1>
    
    <div>
    	<c:set value="${sessionScope.user }" var="asd"/>
    	<h1>${asd.userName }</h1>
	    <c:if test="${!empty sessionScope.user} ">
	    	<h4>Cancel Reservation</h4>
	    </c:if>
	      	<%-- <c:if test="${sessionScope.user.isAdmin} ">
	      		<h4>View Reports</h4>
	      	</c:if>
	    </c:if> --%>
    </div>
    
    <hr/>
    <br/><br/>

   	<table width="1024" border="1" align="center">
         <tr>
           <th rowspan="2" scope="col">Flight No.</th>
           <th rowspan="2" scope="col">Sector</th>
           <th rowspan="2" scope="col">Days</th>
           <th rowspan="2" scope="col">Aircraft Type</th>
           <th rowspan="2" scope="col">Local Departure Time</th>
           <th rowspan="2" scope="col">Local Arrival Time</th>
           <th colspan="3" scope="col">Rates</th>
         </tr>
         <tr>
           <th scope="col">First Class</th>
           <th scope="col">Business Class</th>
           <th scope="col">Economy Class</th>
         </tr>
         
         <c:forEach items="${applicationScope.flightScheduleList}" var="flightSchedule">
         <tr>
           <td>${flightSchedule.flightNo}</td>
           <td>${flightSchedule.sectorId }</td>
           <td>${flightSchedule.day }</td>
           <td>${flightSchedule.aircraftType }</td>
           <td>${flightSchedule.departureTime }</td>
           <td>${flightSchedule.arrivalTime }</td>
           <td>${flightSchedule.firstClassFare }</td>
           <td>${flightSchedule.businessClassFare }</td>
           <td>${flightSchedule.economyClassFare }</td>
         </tr>
         </c:forEach>
       </table> 
       
       <% if(session.getAttribute("user")!=null)
    	   %>
    	   <a href="">Reserve Flight</a>   	 
 
</font>
</body>
</html>
