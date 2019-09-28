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
<title>Reservation details</title>
<style>
body     {background-color: greenyellow;}
p        {color: black;}
input    {display: table-column;}
select    {display: table-column;}
</style>
</head>
<body>
	<h3> Please enter your desired reservation data: </h3>
	<p>
		<jsp:useBean id="obj" class="com.rrn.daos.CarDao" scope="page" />
		
	<form action="ReservationController">
	
		Start date: <input type="text" name="reservationStartDate"> 
		End date: <input type="text" name="reservationEndDate"> 
		Car model:
		<select name="dropdownCarModel">
			<c:forEach var="item" items="${obj.getCarsList()}">
				<option>${item.model}</option>
			</c:forEach>
		</select>
		<p>
		<input type="submit" value="Send Reservation Data">

	</form>
	<p>
	Please kindly note that a reservation can only be cancelled at least 
    72 hours before the starting date. <p>
    To delete a reservation, please re-enter your credentials as well as
	the Start Date and End Date of the reservation. <p>
	
	<form action="DeleteReservation" >
	
		Username: <input type="text" name="uname"> <p>
		Password: <input type="text" name="pass"> <p>
		Start Date: <input type="text" name="reservationStartDate"> <p>
		End Date: <input type="text" name="reservationEndDate"> <p>

		<input type="submit" value="Delete reservation" >

	</form>
	
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
	
</body>
</html>