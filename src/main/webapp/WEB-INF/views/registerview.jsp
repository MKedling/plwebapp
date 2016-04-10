<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">

</head>
<body>

<div class="message">
	${message}
</div>


<div class="container">

	<form method="post" action="/plapp/register" class="form-register">
  		<h2 class="form-signin-heading">Register</h2>
  		
  		<label for="username" class="sr-only">Username</label>
		<input id="username" name="username" type="text" class="form-control" placeholder="Username" required autofocus/>
		
		<label for="password" class="sr-only">Password</label>
		<input id="password" name="password" type="password" class="form-control" placeholder="Password" required>
  		
  		<label for="email" class="sr-only">Email</label>
		<input id="email" name="email" type="email" class="form-control" placeholder="Email" required>
  		
  		
		<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
	</form>
	
</div> <!-- /container -->


<footer>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<script src="<c:url value="/resources/js/notie.js" />"></script>

</footer>
	
</body>
</html>