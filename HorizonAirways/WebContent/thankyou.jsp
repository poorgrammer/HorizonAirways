<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/header.css">
<title>Reservation Success!</title>
</head>
<body>

	<div class="header">
		<div><img src="./images/horizonAirwaysLogo.png" alt="logo" width="200px" height="100px"/></div>
		<div>
			<form>
				<input type="submit" name="logout" value="Log out" />
			</form>
		</div>
	</div>

	<h3>You have successfully scheduled your flight.</h3>
	<h2>Your PNR Number is <u><c:out value="${passenger.pnr}"></c:out></u>.</h2>
	<p>Please keep a copy of your PNR number for future reference. Thank you!</p>
	<br/>
	<div><a href="./index.jsp"><b>Back to Home Page</b></a></<div>

</body>
</html>
