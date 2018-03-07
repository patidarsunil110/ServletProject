<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserList</title>
</head>
<body>
	<table>
		<thead>

			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userss}" var="user">

				<tr>
					<td><c:out value="${user.id}"></c:out></td>
					<td><c:out value="${user.firstName}"></c:out></td>
					<td><c:out value="${user.lastName}"></c:out></td>
					<td><c:out value="${user.address}"></c:out></td>
					<td><a href ="saveUser?action=edit&id=<c:out value="${user.id}"/>">Update</a></td>
					<td><a href="saveUser?action=delete&id=<c:out value="${user.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
	<p>
		<a href="users.jsp">Sign Up</a>
	</p>
</body>
</html>