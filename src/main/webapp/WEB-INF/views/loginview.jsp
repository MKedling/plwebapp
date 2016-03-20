<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<link type="text/css" rel="stylesheet" href="<spring:url value='resources/css/main.css' />" />
<link type="text/css" rel="stylesheet" href="<spring:url value='resources/css/signin.css' />" />

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


</head>
<body>

<div class="message">
	${message}
</div>


<div class="container">

	<form method="post" action="/plapp/login" class="form-signin">
  		<h2 class="form-signin-heading">Please sign in</h2>
  		
  		<label for="username" class="sr-only">Username</label>
		<input id="username" name="username" type="text" value="kalle" class="form-control" placeholder="Username" required autofocus/>
		
		<label for="password" class="sr-only">Password</label>
		<input id="password" name="password" type="password" value="pw" class="form-control" placeholder="Password" required>
  		
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		<a href="/plapp/register" class="btn btn-lg btn-primary btn-block" type="submit">Register</a>
	</form>
	
	
	<c:if test="${param.error != null}">       
			<p>
				Invalid username or password.
			</p>
		</c:if>
		<c:if test="${param.logout != null}">    
			<p>
				You have been logged out.
			</p>
	</c:if>


</div> <!-- /container -->


</body>
</html>