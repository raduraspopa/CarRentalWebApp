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
<title>All cars</title>
<style>
body  {background-color: greenyellow;}
</style>
</head>
<body>
Here you can find the entire list of company cars:<p>
<p>
<table>
<c:forEach var="item" items="${allCars}">
	<tr>
		<td><c:out value="${item.getId()}, ${item.getBrand()}, ${item.getModel()}" /></td>	
	</tr>
</c:forEach>
</table>
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>