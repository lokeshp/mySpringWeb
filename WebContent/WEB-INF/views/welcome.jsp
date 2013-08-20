<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body style="background:#66CCFF">
	<h2 align = "center"> <u>Welcome Page</u></h2>
	<table align="center" width="60%" border="0" >
		<tr>
			 <td align="center" width="30%">
			 	<c:if test="${not empty loginName}">
			 		User : <font color="blue"><c:out value='${logInName}'></c:out></font>
			 	</c:if>
			 </td>
			<td colspan="2">&nbsp;&nbsp;&nbsp;</td>
			<c:if test="${not empty loginId}">
				<td align="center" width="30%"><font color="blue"><a href="signout?loginId=${logInId}">Sign out</a></font></td>
			</c:if>
			<td></td>
		</tr>
		<tr></tr>
		<tr>
			<td></td><td></td>
			<td width="30%"><a href="updateUser?id=${logInId}">Update my details</a></td>
			<td></td><td></td>
		</tr>
		<tr></tr>
		<tr>
			<td></td><td></td>
			<td width="30%"><a href="list">Show Users</a></td>
			<td></td><td></td>
		</tr>
		<tr></tr>
		<tr>
			<td></td><td></td>
			<td width="30%"><a href="registration?name=${logInName}">Register New User</a></td>
			<td></td><td></td>
		</tr>
		<tr>
			<td></td><td></td>
			<td width="30%"><a href="compose?name=${logInName}">Send mail</a></td>
			<td></td><td></td>
		</tr>
		<tr>
			<td></td><td></td>
			<td width="30%"><a href="chatRoom?loginId=${logInId}&name=${logInName}">Chat Room</a></td>
			<td></td><td></td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr>
		<tr><td></td>
			<td colspan="3">
				<c:choose>
					<c:when test="${not empty err_message}">
						<font color="red"><c:out value='${err_message}'></c:out></font>
					</c:when>
					<c:otherwise>
						<font color="green"><c:out value='${message}'></c:out></font>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>








