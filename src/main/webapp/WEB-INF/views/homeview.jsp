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
	<form method="post" action="/demowebapp/plapp/bet">
	
		
	
		<input type="submit" value="betta">
		
		
	</form>
</div>

<div>

	<c:forEach items="${matches}" var="item">
	    
	   <p>${item.homeTeam}</p>
	      
	</c:forEach>
</div>



<div>
	<form method="post" action="/demowebapp/plapp/admin">
		<input type="submit" value="Admin">
	</form>
</div>



	
</body>
</html>