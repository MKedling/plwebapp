<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<body>


	
<div class="login">
	<h2>Login</h2>
	<form method="post" action="/demowebapp/plapp/login/">
		<label for="username">Användarnamn</label>
		<input id="username" name="username" type="text"/>
		
		<label>Lösenord</label>
		<input id="password" name="password" type="password">
		
		<input type="submit" value="logga in">
	</form>
</div>



	
</body>
</html>