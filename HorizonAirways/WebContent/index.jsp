<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.px1.horizonairways.entity.User"%>
<%@page import="com.px1.horizonairways.da.FlightDetailsDA"%>
<%@page import="com.px1.horizonairways.entity.FlightSchedule"%>
<%@page import="com.px1.horizonairways.entity.User"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/index.css">
<title>Horizon Airways</title>
</head>

<body>
	<font face="Arial, Helvetica, sans-serif" size="-1"> <!-- LOGIN FORM -->

		<div class="login">
			<div><p>Horizon Airways</p></div>
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
					<input type="submit" name="submit" value="Log out" align="right"/>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
		
		<div>
			<c:if test="${not empty sessionScope.user}">
				<a href="./cancel.jsp">Cancel Flight</a>
				<c:if test="${sessionScope.user.admin}">
					<a href="./reservation.jsp">View Reports</a>
				</c:if>
			</c:if>
		</div>

		<hr /> <br/>

		<table width="1024" border="1" class="flightDetails">
			<tr>
				<th rowspan="2" scope="col">Flight No.</th>
				<th rowspan="2" scope="col">Sector</th>
				<th rowspan="2" scope="col">Days</th>
				<th rowspan="2" scope="col">Aircraft Type</th>
				<th rowspan="2" scope="col">Departure Time</th>
				<th rowspan="2" scope="col">Arrival Time</th>
				<th colspan="3" scope="col">Rates</th>
				<th rowspan="2" scope="col">Action</th>
			</tr>

			<tr>
				<th scope="col">First Class</th>
				<th scope="col">Business Class</th>
				<th scope="col">Economy Class</th>
			</tr>

			<c:forEach items="${applicationScope.flightScheduleList}"
				var="flightSchedule">

				<tr class="detailItem">
					<td class="flightNo">${flightSchedule.flightNo}</td>

					<td>${flightSchedule.sectorId }</td>
					<td>${flightSchedule.day }</td>
					<td>${flightSchedule.aircraftType }</td>
					<td>${flightSchedule.departureTime }</td>
					<td>${flightSchedule.arrivalTime }</td>
					<td>${flightSchedule.firstClassFare }</td>
					<td>${flightSchedule.businessClassFare }</td>
					<td>${flightSchedule.economyClassFare }</td>
					<td><a href="./reservation?flightNo=${flightSchedule.flightNo}&amp;sectorId=${flightSchedule.sectorId}">Find a flight</a></td>
				</tr>

			</c:forEach>
		</table>

	</font>
	
	

</body>


</html>
