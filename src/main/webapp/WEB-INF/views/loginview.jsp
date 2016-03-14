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
	<form method="post" action="/plapp/login">
		<label for="username">Anv�ndarnamn</label>
		<input id="username" name="username" type="text" value="kalle"/>
		
		<label>L�senord</label>
		<input id="password" name="password" type="password" value="pw">
		
		<input type="submit" value="logga in">
	</form>
	
	<form method="get" action="/plapp/plapp/register">
		<input type="submit" value="skapa konto">
	</form>
	
</div>

<br><br>

<c:if test="${param.error != null}">       
		<p>
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${param.logout != null}">    
		<p>
			You have been logged out.
		</p>
</c:if>




	
</body>
</html>