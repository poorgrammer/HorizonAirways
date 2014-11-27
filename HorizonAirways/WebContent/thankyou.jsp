<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Horizon Airways</title>
</head>
<body>

<h3>You have successfully scheduled your flight.</h3>
<h2>Your PNR Number is <c:out value="${passenger.PNR}"></c:out>. Please keep a copy of your PNR number for future reference. Thank you!</h2>
<div><a href="./index.jsp">Back to home page.</a></div>

</body>
</html>