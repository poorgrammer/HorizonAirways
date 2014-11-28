<%@page import="com.px1.horizonairways.daimpl.FlightDAImpl"%>
<%@page import="com.px1.horizonairways.service.FlightService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seat Picker</title>
<link rel="stylesheet" href="css/seatPickerLayout.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){

	$(".available.seat").click(function(){
		$(".selected.seat").removeClass("selected");
		$(this).addClass("selected");
		$("#seatNo").val($(this).children("div.seatNo").text());
		$("#seatClass").val($(this).children("div.seatClass").text());
	});

});
</script>
</head>
	
	<c:set var="seatPlan" value="${requestScope.passengerSeatPlan}" />
	<div>
		<div class="area">
			${seatPlan.firstClassHTML}
			${requestScope.firstClassZone}
		</div>
		<div class="area">
			${seatPlan.businessClassHTML}
		</div>
		<div class="area">
			${seatPlan.economyClassHTML}
		</div>
		
		<input type="hidden" name="seatNo" id="seatNo" />
		<input type="hidden" name="seatClass" id="seatClass" />
	</div>

</html>
