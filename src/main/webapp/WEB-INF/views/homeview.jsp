<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<body>

<div>
	${userSession.user.username}
</div>

<div>
	<p> Match - Match </p>
</div>

<div>
	<form method="post" action="/demowebapp/plapp/admin">
		<input type="submit" value="Admin">
	</form>
</div>



	
</body>
</html>