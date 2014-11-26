<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.px1.horizonairways.entity.User"%>
<%@page import="com.px1.horizonairways.da.FlightDetailsDA"%>
<%@page import="com.px1.horizonairways.entity.FlightSchedule"%>
<%@page import="com.px1.horizonairways.entity.User"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Horizon Airways</title>
<style>
a {
	cursor: pointer;
}

div {
	background-color: Red;
}
</style>

</head>

<body>
	<font face="Arial, Helvetica, sans-serif" size="-1"> <!-- LOGIN FORM -->

		<c:choose>
			<c:when test="${ empty sessionScope.user}">
				<form action="./login" method="post">
					<table align="right">
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
				<td><input type="submit" name="submit" value="Log out" /></td>
			</c:otherwise>

		</c:choose> <br /> <br /> <br />
		<h1>Horizon Airways</h1>

		<div>
			<c:if test="${not empty sessionScope.user}">
				<a href="./cancel.jsp">Cancel Flight</a>
				<c:if test="${sessionScope.user.admin}">
					<a href="./reservation.jsp">View Reports</a>
				</c:if>
			</c:if>
		</div>

		<hr /> <br /> <br />

		<table width="1024" border="1" align="center">
			<tr>
				<th rowspan="2" scope="col">Flight No.</th>
				<th rowspan="2" scope="col">Sector</th>
				<th rowspan="2" scope="col">Days</th>
				<th rowspan="2" scope="col">Aircraft Type</th>
				<th rowspan="2" scope="col">Departure Time</th>
				<th rowspan="2" scope="col">Arrival Time</th>
				<th colspan="3" scope="col">Rates</th>
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
					<td><a
						href="./reservation?flightNo=${flightSchedule.flightNo}&amp;sectorId=${flightSchedule.sectorId}
					&amp;firstClassFare=${flightSchedule.firstClassFare }&amp;businessClassFare=${flightSchedule.businessClassFare }&amp;economyClassFare=${flightSchedule.economyClassFare }">Reserve</a></td>
				</tr>

			</c:forEach>
		</table>


	</font>

</body>


</html>
