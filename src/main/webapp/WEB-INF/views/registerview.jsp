<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<body>

<div>
	<form method="post" action="/demowebapp/plapp/register">
		<label for="username">Anv�ndarnamn</label>
		<input id="username" name="username" type="text"/>
		
		<label>L�senord</label>
		<input id="password" name="password" type="password">
		
		<label>Email</label>
		<input id="email" name="email" type="email">
		
		<input type="submit" value="logga in">
	</form>
</div>
	
</body>
</html>