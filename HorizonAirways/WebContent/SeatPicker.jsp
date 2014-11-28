<%@page import="com.px1.horizonairways.daimpl.FlightDAImpl"%>
<%@page import="com.px1.horizonairways.service.FlightService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title</title>
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
<head>
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
<body>
<div class="area">
${requestScope.firstClassZone}
</div>
<div class="area">
${requestScope.businessClassZone}
</div>
<div class="area">
${requestScope.economyClassZone}
</div>
<input type="hidden" name="seatNo" id="seatNo" />
<input type="hidden" name="seatClass" id="seatClass" />
</body>
</html>