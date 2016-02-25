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


${nextMatchToBet.starttime}

<div class="page">
<div class="container-fluid">
<div class="row">
<div class="main-content col-centered col-lg-12">

<div class="list-group">
	<div>
		<a href="admin">Admin</a>
	</div>

	<div class="list-group-item">
		<p class="username">
			${userSession.user.username}
		</p>
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
	<div class="list-group-item">
		<h3 class="heading">
			Highscore
		</h3>
		<div class="wrapper col-lg-6">
			<div class="total-score score-section">
				<h4>
					Total:
				</h4>
				<c:forEach items="${totalHighscore}" var="entry">
					<span class="highscore-entry">${entry.user.username}: <span class="value">${entry.score}</span></span>
				   	<br> 
				</c:forEach>
			</div>
		</div>
		<div class="wrapper col-lg-6">
			<div class="round-score score-section">
				<h4>
					Round:
				</h4>
				<c:forEach items="${roundHighscore}" var="entry">
					<span class="highscore-entry">${entry.user.username}: <span class="value">${entry.score}</span></span>
				   	<br> 
				</c:forEach>
			</div>
		</div>
	</div>
</div>




<div class="list-group">
	
	<div class="pagination round">
		<form id="pagination_form" method="POST" action="/demowebapp/plapp/login/update">
			<span class="plus_minus" data-name="quantity" data-value="${roundToView}" data-id="101"></span>
		</form>
	</div>
	
	<c:forEach items="${matchesToBet}" var="match">
		<c:set var="match" value="${match}" scope="request" />
		<c:set var="matchType" value="matchToBet" scope="request" />
	    <jsp:include page="match.jsp"/>   
	</c:forEach>
	
	<c:forEach items="${bets}" var="bet">
		<c:if test = "${bet.round == roundToView}">
			
				<c:set var="bet" value="${bet}" scope="request" />
				<c:set var="matchType" value="matchBetExist" scope="request" />
			    <jsp:include page="match.jsp"/>   
			
	   </c:if>
   </c:forEach>
	
</div>



</div><!-- main content-->
</div>	<!-- row -->
</div> <!-- container fluid -->
</div> <!-- page -->

</body>
</html>