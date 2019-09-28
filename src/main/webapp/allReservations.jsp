<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
if(session.getAttribute("username")==null){
	response.sendRedirect("http://localhost:8080/WebAppCarRental/index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation history</title>
<style>
body  {background-color: greenyellow;}
</style>
</head>
<body>
Here you can find the entire list of reservations:<p>
<p>
<table>
<c:forEach var="item" items="${allReservations}">
	<tr>
		<td><c:out value="Reservation Id: ${item.getReservation_id()}, CLient Id: ${item.getClient_id()},
						  Car Id: ${item.getCar_id()}, Start Date: ${item.getStart_date()}
						  End Date: ${item.getEnd_date()}, Price: ${item.getPrice()}"/></td>				 
	</tr>
</c:forEach>
</table>
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>