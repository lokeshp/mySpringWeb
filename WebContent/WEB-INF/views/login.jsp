<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
</head>
<body style="background:#6699FF" onload='document.login_form.userName.focus();'>
	<h2 align = "center"> <u>Log In </u></h2>
	<form name="login_form"action="login" method="POST">
		<table align="center">
			<tr>
				<td colspan="3" style="color:red"><c:out value="${error_msg}"></c:out></td>
			</tr>
			<tr>
				<td>User Name  </td>
				<td colspan="2"><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>Password  </td>
				<td colspan="2"><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Log In"/></td>
				<td colspan="2"><input type="reset" value="Cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;<font size="2"><a href="registration">New User</a></font></td>
			</tr>
		</table>
	</form>
	
</body>
</html>