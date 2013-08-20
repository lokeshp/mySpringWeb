<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Composer Mail</title>
<script>
	function checkOption(obj){
		if(obj.value == "Other")	document.getElementById("idText").style.display="block";
		else						document.getElementById("idText").style.display="none";
		
	}
	function checkvalues(){
		var mail_id = document.getElementById("fromId").value;
		if(mail_id.length > 0 && mail_id.indexOf("@") == -1)
			document.getElementById("fromId").value = mail_id+'@gmail.com';
		mail_id = document.getElementById("mailToVal").value;
		if(mail_id != "Other")
			document.getElementById("toId").value = mail_id;
		mail_id = document.getElementById("toId").value;
		if(mail_id.length > 0 && mail_id.indexOf("@") == -1)
			document.getElementById("toId").value = document.getElementById("toId").value+document.getElementById("hostVal").value;
	}
</script>
</head>
<body  style="background:#99FFFF">
	<h2 align = "center"> <u>Compose Mail</u></h2>
	<form action="mailSend" method="POST" onsubmit="checkvalues()">
		<table width="90%" border="0" align="center">
			<tr>
				<td nowrap>From Mail</td>
				<td><input type="text" id="fromId" name="fromId" size="40">@gmail.com<font color="red">*</font></td>
				<td><a href="welcome">&larr; Back</a></td>
			</tr>
				
			<tr>
				<td nowrap>Password</td>
				<td colspan="2"><input type="password" name="password" size="40"><font color="red">*</font></td>
			</tr>
			<tr>
				<td nowrap>To Mail</td>
				<td colspan="2">
					<select id="mailToVal" onChange="checkOption(this)">
						<option value="">-- Select --</option>
						<c:forEach var="user" items="${users}">
							<option value="<c:out value="${user.email}"/>"><c:out value="${user.email}"/></option>
						</c:forEach>
						<option value="Other">Other Mail Id</option>
					</select>
					<font color="red">*</font>
					<span id="idText" style="display:none" >
						<input type="text" name="toId" size="40">
						<select id="hostVal">
							<option value="@gmail.com">@gmail.com</option>		
							<option value="@manuhindia.com">@manuhindia.com</option>
							<option value="@yahoo.com">@yahoo.com</option>						
							<option value="@yahoo.co.in">@yahoo.co.in</option>						
							<option value="@rediff.com">@rediff.com</option>
						</select>
					</span></td>
			</tr>
					
			
			<tr>
				<td nowrap>Subject</td>
				<td colspan="2"><input type="text" name="subject" size="40"><font color="red">*</font></td>
			</tr>

			<tr>
				<td valign="top">Mail Body</td>
				<td colspan="2"><textarea name="mailBody" cols="90" rows="15"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td colspan="2">
					<input type="submit" value="Send">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="Clear all">
					<font color="red" size="2"><c:out value="${message}"/></font>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>