<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


<script src="<c:url value="/resources/js/bootstrapPlusMinus.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>


</head>
<body>


<div class="page">
<div class="container-fluid">
<div class="row">
<div class="main-content col-centered col-lg-12">



<div class="list-group">

	<div class="list-group-item">
	<div>
		<span>ADMINVIEW</span>
	</div>	
	<div>
		<form method="post" action="admin/addMatches">
			<input name="fileName" type="hidden" value="pl.txt">
			<input type="submit" value="l�gg till matcher">
		</form>
	</div>
	</div>

	<c:forEach items="${matchesToAddResult}" var="match">
		<c:set var="match" value="${match}" scope="request" />
		<c:set var="matchType" value="matchToAddResult" scope="request" />
	    <jsp:include page="match.jsp"/>   
	</c:forEach>

</div>



</div><!-- main content-->
</div>	<!-- row -->
</div> <!-- container fluid -->
</div> <!-- page -->
	
</body>
</html>