<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
<form action="UserController" method="post">
		<table>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="Email"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="Password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>