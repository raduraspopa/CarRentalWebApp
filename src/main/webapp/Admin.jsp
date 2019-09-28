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
<title>Admin</title>
<style>
body     {background-color: greenyellow;}
p        {color: black;}
input    {display: table-column;}
select    {display: table-column;}
</style>
</head>
<body>
	<h2>Welcome!</h2>
	<p>
	<p>
	Here you can manage all cars, clients and reservations!<p>
	Choose what type of information would you like to consult:<p>
	
	<form action="AdminActions">
	
		<select name="adminSelectedAction">
				<option>Entire list of the company's cars</option>
				<option>Entire list of the company's clients</option>
				<option>Full history of reservations</option>
		</select>
	<input type="submit" value="Submit">

	</form>
	<p>

		To delete a car, please select it from the list below:
		<jsp:useBean id="obj" class="com.rrn.daos.CarDao" scope="page" />

	<form action="DeleteCar">
	
	<select name="dropdownCarModel">
			<c:forEach var="item" items="${obj.getCarsList()}">
				<option>${item.id}, ${item.model}, ${item.brand}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Delete car">

	</form>

<p>

To add a new car, please provide the following information:
	<p>


	<form action="AddCar">
	
		Enter car brand: <input type="text" name="brand"> <p>
		Enter car model: <input type="text" name="model"> <p>
		Is the new car automatic?
		<select name="isAutomatic">
				<option>yes</option>
				<option>no</option>
		</select>
		<p>
		Is the new car equipped with climate control system?
		<select name="hasAC">
				<option>yes</option>
				<option>no</option>
		</select>
		<p>
		Enter the new car's price per day: <input type="text" name="price"> <p>

		<input type="submit" value="Add car">
	</form>
<p>

	<form action="Logout">
		<input type="submit" value="Logout">
	</form>

</body>
</html>