<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<body>

ADMINVIEW

<div>

	<form method="post" action="admin/addMatches">
		<input name="fileName" type="hidden" value="pl.txt">
		<input type="submit" value="lägg till matcher">
	</form>
	
	
</div>


	
</body>
</html>