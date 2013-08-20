<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body style="background:#66CCFF">
	<h2 align = "center"> <u>User Registration </u></h2>	
	<form action="register" method="POST">
		<table align="center" border="0">
		
			 <c:if test="${not empty logInName}">
			 	<tr>
					<td align="center" width="30%">User : <font color="blue"><c:out value='${logInName}'></c:out></font></td>
					<td></td><td></td><td></td>
					<c:if test="${not empty logInId}">
						<td align="center" width="30%"><font color="blue"><a href="signout?logInId=${logInId}">Sign out</a></font></td>
					</c:if>
				</tr>
			</c:if>
			<tr>
				<td></td><td></td>
				<td colspan="3">
					<font color="red">*</font><font size="2">Mandatory fields</font>
					 <c:if test="${empty logInName}">
						<font color="blue" size="2">&nbsp;&nbsp;&nbsp;<a href="signout">Click here</a> to log in</font>
					</c:if>
				</td>
				<td></td><td></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>Name</td>
				<td><input type="text" name="name"/></td>
				<td style="color:red">*</td>
				<td></td><td></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>User Name  </td>
				<td><input type="text" name="userName"/></td>
				<td style="color:red">*</td>
				<td></td><td></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>Password  </td>
				<td><input type="password" name="password"/></td>
				<td style="color:red">*</td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>E-mail  </td>
				<td><input type="text" name="email"/></td>
				<td style="color:red">*</td>
				<td></td><td></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td>Location  </td>
				<td><input type="text" name="location"/></td>
				<td style="color:red">*</td>
				<td></td><td></td>
			</tr>
			<tr>
				<td></td><td></td>
				<td><input type="submit" value="Register"/></td>
				<td colspan="2"><input type="reset" value="Cancel"/>
				<font color="red" size="2"><c:out value="${message}"/></font></td>
				<td></td><td></td>
			</tr>
		</table>
	</form>
	
</body>
</html>
