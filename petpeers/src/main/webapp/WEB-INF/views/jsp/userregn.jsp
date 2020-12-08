<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page errorPage="errorPage"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>


</head>
<body>

In userregn: ..
<a href="registered">REG</a>
	<div align="center">
		<form:form action="register" method="post" modelAttribute="user" >
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>User Registration</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="username" /></td><form:errors ></form:errors>
					
					
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password id="pswd1" path="userPassword" /></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><form:password id="pswd2" path="confirmPassword" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<button type="submit" >Submit</button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>