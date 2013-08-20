<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	
	<h1>Hello Guest !!!</h1>

	<form action="welcome" method="get">
		Name : <input type="text" name="name"/><input type="submit" value="submit"/>
	</form>
	
</body>
</html>