<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
	<form action="saveUser" method="POST">
		<input type="hidden" name="id" value="${userss.id}" /> 
		First Name<input type="text" name="firstName" value="${userss.firstName}" /> 
		Last Name<input	type="text" name="lastName" value="${userss.lastName}" /> 
		Address<input type="text" name="address" value="${userss.address}" />
		 <input	type="submit" value="Save">
	</form>

</body>
</html>