<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/passenger.css">
<title>Passenger Details</title>


<style>
table{
	border-collapse: collapse;
}
table,tr,td{
border: solid 1px black ;
}
td{

	min-height:10px;
	min-width:10px;
	padding: 2px; 
}
.seat{
	cursor:pointer;
}
.occupied.seat{
	background-color: #dd0000;
}

.selected{
	background-color: #00ff00 !important;
}
.available.seat{
	background-color: #dddddd;
}

div.area{
	width: 100%;
	display: flex;
	justify-content:center;
}
</style>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	
	$( ".available.seat").click(function(){
		
		if($(this).parents(".${requestScope.flightId1}").length){
			$("#firstSeatNo").val($(this).children("div.seatNo").text());
			$("#firstSeatClass").val($(this).children("div.seatClass").text());
			$(".${requestScope.flightId1} .selected.seat").removeClass("selected");
			$(this).addClass("selected");
		}if($(this).parents(".${requestScope.flightId2}").length){
			$("#secondSeatNo").val($(this).children("div.seatNo").text());
			$("#secondSeatClass").val($(this).children("div.seatClass").text());
			$(".${requestScope.flightId2} .selected.seat").removeClass("selected");
			$(this).addClass("selected");
		}

	});

});
</script>

<!--  END OF GAWA NI NINO -------------------->
<!--  END OF GAWA NI NINO -------------------->
<!--  END OF GAWA NI NINO -------------------->
<!--  END OF GAWA NI NINO -------------------->
<!--  END OF GAWA NI NINO -------------------->
<!--  END OF GAWA NI NINO -------------------->
<!--  END OF GAWA NI NINO -------------------->
<!--  END OF GAWA NI NINO -------------------->
<!--  END OF GAWA NI NINO -------------------->


</head>
<body>


<form action="./PassengerDetails" method="post">
<div>
	<fieldset>


	<div class="header">
		<img src="./images/horizonAirwaysLogo.png" alt="logo" width="200px" height="100px"/>
	</div>


	<fieldset>

		<legend>Personal Details Form</legend>
	

		<div>
			<label for="firstName">First Name: </label>
			<input type="text"  name="firstName" id="firstName" required>
		</div>
		<div>
			<label for="lastName">Last Name: </label>
			<input type="text" name="lastName" id="lastName" required>
		</div>
		<div>
			<label for="address">Address: </label>
			<textarea  name="address" id="address" required></textarea>
		</div>
		<div>
			<label for="gender">Gender: </label>
			<select name="gender" required>
				<option value="M">Male</option>
				<option value="F">Female</option>
			</select>
		</div>
		<div>
			<label for="birthDay">Birth Day: </label>
			<input type="date" name="birthDay" id="birthDay" required>
		</div>
		<div>
			<label for="mobileNo">Mobile Number: </label>
			<input type="text" name="mobileNo" id="mobileNo">
		</div>
		<div>
			<label for="emailAddress">Email Address: </label>
			<input type="email" name="emailAddress" id="emailAddress">
		</div>
		
		<div>
			<label for="mealPreference">Meal Preference: </label>
			<input type="text" name="mealPreference" id="mealPreference" required>
		</div>
		
		<div>
			<label for="SSR">SSR: </label>
			<input type="text" name="SSR" id="SSR" required placeholder="Put NA if not applicable">
		</div>
		
		<div><h2>Flight Reservation Preferences</h2></div>
		
		<div>
			<label for="firstSeatNo">Seat No: </label>
			<input type="text" name="firstSeatNo" id="firstSeatNo" class="${requestScope.flightId1}" required>
		</div>
		
		<div>
			<label for="firstSeatClass">Seat Class: </label>
			<input type="text" name="firstSeatClass" id="firstSeatClass" class="${requestScope.flightId1}" required>
		</div>
		
	
		
		<% 
			if(session.getAttribute("secondFlight")!=null){
		%>
				
				<div><h2>Second Flight Reservation Preferences</h2></div>
		
		<div>
			<label for="secondSeatNo">Seat No: </label>
			<input type="text" name="secondSeatNo" id="secondSeatNo" class="${requestScope.flightId2}" required>
		</div>
		
		<div>
			<label for="secondSeatClass">Seat Class: </label>
			<input type="text" name="secondSeatClass" id="secondSeatClass" class="${requestScope.flightId2}" required>
		</div>
		
				
		<% 
			}
		%>
		
		
		<div class="button">
			<input type="submit" value="Submit"/>
		</div>


	</fieldset>
	</form>



<c:set var="firstSeatPlan" value="${requestScope.firstPassengerSeatPlan}" />

<div>

<div class="area">

${firstSeatPlan.firstClassHTML}



</div>
<div class="area">
${firstSeatPlan.businessClassHTML}
</div>
<div class="area">
${firstSeatPlan.economyClassHTML}
</div>
<input type="hidden" name="seatNo" id="seatNo" />
<input type="hidden" name="seatClass" id="seatClass" />
</div>
<br/>
<br/>
<hr/>
<br/>
<br/>
<c:if test="${not empty requestScope.secondPassengerSeatPlan}">
	<c:set var="secondSeatPlan" value="${requestScope.secondPassengerSeatPlan}" />
	<div>
		<div class="area">
		${secondSeatPlan.firstClassHTML}
		</div>
		<div class="area">
		${secondSeatPlan.businessClassHTML}
		</div>
		<div class="area">
		${secondSeatPlan.economyClassHTML}
		</div>
		<input type="hidden" name="seatNo" id="seatNo" />
		<input type="hidden" name="seatClass" id="seatClass" />
	</div>
</c:if>

</body>
</html>
