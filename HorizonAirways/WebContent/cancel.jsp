<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.px1.horizonairways.entity.ReservedFlight"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/cancel.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/tableDesign.css">
<title>Horizon Airways</title>
</head>
<body>
<font face="Arial, Helvetica, sans-serif" size="-1">
	<div class="header">
		<div><img src="./images/horizonAirwaysLogo.png" alt="logo" width="200px" height="100px"/></div>
		<div>
			<form>
				<input type="submit" name="logout" value="Log out" />
			</form>
		</div>
	</div>

	<div class="formDiv">
	<form action="./CancelReservation" method="post">
		<br />
		<label for="pnrNo">Please input PNR No: </label><input type="text" name="pnrNo"/>
		<input type="submit" value="Search"/>
		
		<div>
			<h3>Personal Details Form</h3>
				<div>
					<label for="firstName">First Name: </label>
					<input type="text"  name="firstName" id="firstName" disabled value="${requestScope.passenger.firstName}">
				</div>
				<div>
					<label for="lastName">Last Name: </label>
					<input type="text" name="lastName" id="lastName" disabled value="${requestScope.passenger.firstName}" >
				</div>
				<div>
					<label for="address">Address: </label>
					<textarea  name="address" id="address" disabled>${requestScope.passenger.lastName}</textarea>
				</div>
				<div>
					<label for="gender">Gender </label>
					<input type="text" name="gender" id="gender" disabled value="${requestScope.passenger.gender}" >
				</div>
				<div>
					<label for="birthDay">Birth Day: </label>
					<input type="date" name="birthDay" id="birthDay" disabled value="${requestScope.passenger.birthDay}">
				</div>
				<div>
					<label for="mobileNo">Mobile Number: </label>
					<input type="text" name="mobileNo" id="mobileNo" disabled value="${requestScope.passenger.mobileNo}">
				</div>
				<div>
					<label for="emailAddress">Email Address: </label>
					<input type="email" name="emailAddress" id="emailAddress" disabled value="${requestScope.passenger.emailAddress}">
				</div>
			</fieldset>
		</div>
	
	</form>
	</div>
	
	<% if((request.getAttribute("reservedFlights")!=null) && (((List<ReservedFlight>)request.getAttribute("reservedFlights")).size() != 0)){ %>
		<div class="tableContainer">
		<div class="reservedFlightsTable" >
			<div class="row">
				<div class="cell"><h3>Flight No.</h3></div>
				<div class="cell"><h3>FlightDate</h3></div>
				<div class="cell"><h3>Seat No</h3></div>
				<div class="cell"><h3>Class</h3></div>
				<div class="cell"><h3>Meal</h3></div>
				<div class="cell"><h3>SSR</h3></div>
			</div>
			
			<c:forEach items="${requestScope.reservedFlights}" var="reservedFlight">			
				<div class="row">
					<div class="cell">${reservedFlight.flightNo}</div>
					<div class="cell">${reservedFlight.flightDate }</div>
					<div class="cell">${reservedFlight.seatNo }</div>
					<div class="cell">${reservedFlight.seatClass }</div>
					<div class="cell">${reservedFlight.mealPreference }</div>
					<div class="cell">${reservedFlight.SSR }</div>
				</div>
			</c:forEach>
			
			<%-- <table class="flightDetails">
				<tr>
					<th rowspan="2"></th>
					<th rowspan="2">FlightDate</th>
					<th rowspan="2">Seat No</th>
					<th rowspan="2">Class</th>
					<th rowspan="2">Meal</th>
					<th rowspan="2">SSR</th>
				</tr>
	
				<c:forEach items="${requestScope.reservedFlights}" var="reservedFlight">
				<tr>
					<td>${reservedFlight.flightNo}</td>
					<td>${reservedFlight.flightDate }</td>
					<td>${reservedFlight.seatNo }</td>
					<td>${reservedFlight.seatClass }</td>
					<td>${reservedFlight.mealPreference }</td>
					<td>${reservedFlight.SSR }</td>
				</tr>
				</c:forEach>
			</table> --%>
			
			<br>
			<a href="./CancelReservation?flightNo=${reservedFlight.flightNo}&amp;pnrNo=${requestScope.passenger.pnr}">
				<b>Cancel Reservation</b>
			</a>
		</div>
		</div>
	<%
		} else if(request.getAttribute("passenger")!=null) {
	%>
		
		<br />
		<h3>There are no scheduled flights for this passenger. 
			<br/><a href="./index.jsp">Back to home page.</a>
		</h3>
	
	<%
		}
	%>

</font>
</body>
</html>
