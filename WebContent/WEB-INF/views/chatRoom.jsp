<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body style="background:#84FFFF">
	<h2 align = "center"> <u>Online Users</u></h2>
	<table align="left" border="0" width="50%">
		<tr>
			<td align="left"><a href="welcome?id=${loginId}">&larr; Back</a></td>
			<td></td><td></td>
			<td align="center">
				<c:if test="${not empty loginName}">
			 		User : <font color="blue"><c:out value='${loginName}'></c:out></font>
			 	</c:if>
			<td></td><td></td>
			<c:if test="${not empty loginId}">
				<td align="right" ><font color="blue"><a href="signout?loginId=${loginId}">Sign out</a></font></td>
			</c:if>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
			<td><b>Users</b></td>
		</tr>
		<tr>
		<c:forEach var="user" items="${onlineUsers}">
			<tr>
				<td><a href="chatUser?chatUserId=${user.id}"><c:out value="${user.name}"/></a></td>
			</tr>   
		</c:forEach>
		</tr>
	</table>
</body>
</html>