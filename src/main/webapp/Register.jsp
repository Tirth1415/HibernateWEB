<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
	<form action="UserController" method="post">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="Name"></td>
			</tr>
			<tr>
				<td>Contact :</td>
				<td><input type="text" name="Contact"></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="Address"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="Email"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="Password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="Register"></td>
			</tr>
		</table>
	</form>

</body>
</html>