<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/passenger.css">
<title>Passenger Details</title>
</head>
<body>

	<div class="header">
		<img src="./images/horizonAirwaysLogo.png" alt="logo" width="200px" height="100px"/>
	</div>


	<fieldset>
		<legend>Personal Details Form</legend>
	

		<div>
		
			<label for="firstName">First Name: </label>
			<input type="text"  name="firstName" id="firstName">
		</div>
		<div>
			<label for="lastName">Last Name: </label>
			<input type="text" name="lastName" id="lastName" >
		</div>
		<div>
			<label for="address">Address: </label>
			<textarea  name="address" id="address"></textarea>
		</div>
		<div>
			<label for="gender">Gender: </label>
			<select name="gender">
				<option value="M">Male</option>
				<option value="F">Female</option>
			</select>
		</div>
		<div>
			<label for="birthDay">Birth Day: </label>
			<input type="date" name="birthDay" id="birthDay">
		</div>
		<div>
			<label for="mobileNo">Mobile Number: </label>
			<input type="text" name="mobileNo" id="mobileNo" >
		</div>
		<div>
			<label for="emailAddress">Email Address: </label>
			<input type="email" name="emailAddress" id="emailAddress">
		</div>
		
		<div class="button">
			<input type="submit" value="Submit"/>
		</div>


	</fieldset>
	<br />

</body>
</html>
