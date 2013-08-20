<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body style="background:#66CCFF">
	<h2 align = "center"> <u>User Information</u></h2>	
	<form action="update" method="POST">
		<table align="center" border="0">		
			<tr></tr><tr></tr>
			<tr>
				<c:choose>
				    <c:when test="${not empty logInName}">
				       <td align="center" width="30%">User : <font color="blue"><c:out value='${logInName}'></c:out></font></td>
				    </c:when>
				    <c:otherwise>
				    	<td></td>
				    </c:otherwise>
				</c:choose>
				<td></td><td></td><td></td>
				<c:if test="${not empty logInId}">
					<td align="center" width="30%"><font color="blue"><a href="signout?logInId=${logInId}">Sign out</a></font></td>
				</c:if>
					
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="<c:out value="${userData.id}"></c:out>"/></td><td></td>
				<td>Name</td>
				<td><input type="text" name="name" value="<c:out value="${userData.name}"></c:out>"/></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>User Name  </td>
				<td><input type="text" name="userName" value="<c:out value="${userData.userName}"></c:out>"/></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>Password  </td>
				<td><input type="password" name="password" value="<c:out value="${userData.password}"></c:out>"/></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>E-mail  </td>
				<td><input type="text" name="email" value="<c:out value="${userData.email}"></c:out>"/></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>Location  </td>
				<td><input type="text" name="location" value="<c:out value="${userData.location}"></c:out>"/></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td><input type="submit" value="Update"/></td>
				<td><input type="reset" value="Cancel"/>
				<font color="red" size="2"><c:out value="${message}"/></font></td>
				<td></td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td align="center"><a href="welcome?id=${logInId}">&larr; Back</a></td>
				<td colspan="2"></td>
				<!-- <td align="center" width="30%"><font color="blue"><a href="registration">Add new user</a></font></td> -->
				<td align="center" width="30%"><a href="list">Users list</a></td><td></td>
				<td></td>
			</tr>
		</table>
	</form>
	
</body>
</html>
