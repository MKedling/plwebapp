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
	<form method="post" action="demowebapp/login">
		<label for="username">Användarnamn</label>
		<input id="username" name="username" type="text" value="kalle"/>
		
		<label>Lösenord</label>
		<input id="password" name="password" type="password" value="pw">
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
		<input type="submit" value="logga in">
	</form>
	
	<form method="get" action="/demowebapp/plapp/register">
		<input type="submit" value="skapa konto">
	</form>
	
</div>

<br><br><br>

<div>
	<c:url value="plapp/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">      
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
	<p>
		<label for="username">Username</label>
		<input type="text" id="username" name="username"/>
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password"/>
	</p>
	<input type="hidden"                  
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn">Log in</button>
</form>

</div>




	
</body>
</html>