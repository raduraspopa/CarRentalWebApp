<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to car rental!</title>
<style>
body     {background-color: orange;}
h2       {color: midnightblue;}
input    {display: block; text-align: center; width:150px; color: black;}

</style>
</head>
<body>
<h2>Welcome to car rental!</h2><p>
Please login to make a new reservation:
	<p>
	<form action="Login">
	Enter username: <input type="text" name="uname"><br>
	Enter password: <input type="password" name="pass"><br>
	<input type="submit" value="Login">
	</form>
	<p>
If you do not have an account, please sign up:<p>	
	<form action="SignUp">
	Enter CNP: <input type="text" name="cnp"><br>
	Enter desired username: <input type="text" name="desiredUname"><br>
	Enter desired password: <input type="password" name="desiredPass"><br>
	Enter you first name: <input type="text" name="firstName"><br>
	Enter you last name: <input type="text" name="lastName"><br>
	Enter you phone number: <input type="text" name="phoneNumber"><br>
	
	<input type="submit" value="Sign Up">
	</form>
	
</body>
</html>
