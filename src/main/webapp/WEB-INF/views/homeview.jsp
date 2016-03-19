<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


<script src="<c:url value="/resources/js/bootstrapPlusMinus.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>


</head>
<body>

<div>
	<jsp:include page="navbar.jsp"/>
</div>

<div class="page">
<div class="container-fluid">
<div class="row">
<div class="main-content col-centered col-lg-12">



<jsp:include page="popup.jsp"/>


<div class="list-group">
	<div>
		<a href="/plapp/plapp/admin">Admin</a>
	</div>

	<div class="list-group-item">
		<p>
			Current round: ${currentRound}
		</p>
		<p>
			Round Score: ${scoreRound}
		</p> 
		<p>
			Total Score: ${scoreTotal}
		</p>
		
	</div>
</div>


<div class="list-group highscore">
	
	<c:set var="totalHighscore" value="${totalHighscore}" scope="request" />
	<c:set var="roundHighscore" value="${roundHighscore}" scope="request" />
	<jsp:include page="highscore.jsp"/>
	
</div>


<div class="list-group">
	
	<c:forEach items="${matchesToBet}" var="match">
		<c:set var="match" value="${match}" scope="request" />
		<c:set var="matchType" value="matchToBet" scope="request" />
	    <jsp:include page="match.jsp"/>   
	</c:forEach>
	
	<c:forEach items="${allBetsRound}" var="bet">
		
		<c:set var="match" value="${bet}" scope="request" />
		<c:set var="matchType" value="matchBetExist" scope="request" />
	    <jsp:include page="match.jsp"/>   
	 
   </c:forEach>
</div>
   


</div><!-- main content-->
</div>	<!-- row -->
</div> <!-- container fluid -->
</div> <!-- page -->

</body>
</html>