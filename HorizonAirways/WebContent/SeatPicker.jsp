<%@page import="com.px1.horizonairways.daimpl.FlightDAImpl"%>
<%@page import="com.px1.horizonairways.service.FlightService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
table{
	border-collapse: collapse;
}
table,tr,td{
border: solid 1px black ;
}
td{
	min-height:20px;
	min-width:20px;
	padding: 5px; 
}

.occupiedSeat{
	background-color: red;
}

.availableSeat{
	background-color: green;
}
</style>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){

	$(".availableSeat").click(function(){
	alert($(this).text());
		$("#seatNo").val($(this).text());
	});

});
</script>

<div>
${requestScope.firstClassZone}
${requestScope.businessClassZone}
${requestScope.economyClassZone}
<input type="hidden" name="seatNo" id="seatNo" />
<input type="hidden" name="seatClass" id="seatClass" />
</div>

</html>