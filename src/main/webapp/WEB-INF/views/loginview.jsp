<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<body>

<div class="message">
	${message}
</div>

	
<div class="login">
	<h2>Login</h2>
	<form method="post" action="/demowebapp/plapp/login/">
		<label for="username">Användarnamn</label>
		<input id="username" name="username" type="text" value="kalle"/>
		
		<label>Lösenord</label>
		<input id="password" name="password" type="password" value="pw">
		
		<input type="submit" value="logga in">
	</form>
	
	<form method="get" action="/demowebapp/plapp/register">
		<input type="submit" value="skapa konto">
	</form>
	
</div>




	
</body>
</html>