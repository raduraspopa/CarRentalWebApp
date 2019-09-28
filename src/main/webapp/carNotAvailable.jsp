<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The selcted car is not available</title>
<style>
body     {background-color: greenyellow;}
p        {color: red;}
</style>
</head>
<body>
<p>
Unfortunately, the selected car is not available during the inserted time interval. 
<p>
The available cars are the following:
<table>
<c:forEach var="item" items="${availableCars}">
	<tr>
		<td><c:out value="${item.brand} ${item.model}" /></td>	
	</tr>
</c:forEach>
</table>
<a href="http://localhost:8080/WebAppCarRental/carReservationRequest.jsp">Click here to re-enter the shift details</a>
</body>
</html>