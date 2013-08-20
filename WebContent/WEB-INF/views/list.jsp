<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body style="background:#84FFFF">
	<h2 align = "center"> <u>List of Users</u></h2>
	<table align="center">
		<tr>
			<td align="center">
				<c:if test="${not empty logInName}">
			 		User : <font color="blue"><c:out value='${logInName}'></c:out></font>
			 	</c:if>
			<td></td>
			<c:if test="${not empty logInId}">
				<td align="left" ><font color="blue"><a href="signout?logInId=${logInId}">Sign out</a></font></td>
			</c:if>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
			<td></td>
			<td>
			<table align="center" border="1">		
				<tr>
					<td></td>
					<td><b>S No</b></td>
					<td><b>Name</b></td>
					<td><b>User Name</b></td>
					<td><b>Email</b></td>
					<td><b>Location</b></td>
					<td></td>
					<td></td>
				</tr> 
				<c:set var="count" value="0"/>
				<c:forEach var="user" items="${users}">
				<c:set var="count" value="${count + 1}" scope="page"/>
					<tr>
						<td></td>
						<td><c:out value="${count}"/></td>
						<td><c:out value="${user.name}"/></td>
						<td><c:out value="${user.userName}"/></td>
						<td><c:out value="${user.email}"/></td>
						<td><c:out value="${user.location}"/></td>
						<td><a href="updateUser?id=${user.id}">Edit</a></td>
						<td><a href="delete?id=${user.id}" onClick="return confirm('Are you sure you want to delete?')">Delete</a></td>
						<td></td>
					</tr>   
				</c:forEach>
			</table>
			</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
			<td align="center"><a href="welcome?id=${logInId}">&larr; Back</a></td>
			<td></td>
			<td align="center" ><a href="registration">Register New User</a></td>
		</tr>
	</table>
</body>
</html>