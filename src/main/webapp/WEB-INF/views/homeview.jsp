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

<div>
	${userSession.user.username} : ${score} 
	
</div>



<div class="list-group">
	<div class="pagination">
		<span class="plus_minus" data-name="quantity" data-value="0" data-id="10"></span>
	</div>
	<c:forEach items="${matchesToBet}" var="match">
		
		<div class="list-group-item">
			
			${match.starttime}
			
			<div>
		   		<span class="team_name"> ${match.homeTeam}</span>
		   		<span id="home_team_match_${match.ID}" class="plus_minus home_team" data-name="score_home" data-value="0" data-id="${match.ID}"></span>
		   	</div>
		   	<div>
		   		<span class="team_name">${match.awayTeam}</span>
		   		<span id="away_team_match_${match.ID}" class="plus_minus away_team" data-name="score_away" data-value="0" data-id="${match.ID}"></span>
		   	</div>
		   	
		   		<input type="hidden" name="match_id" value="${match.ID}" /> 
		   		<button type="button" class="btn btn-primary bet" value="">Primary</button> 	
		   		
	   	</div>	
	   	 
	</c:forEach>
	<c:forEach items="${alreadyBetted}" var="match">
		
		<div class="list-group-item">
			
			${match.starttime}
			
			<div>
		   		<span class="team_name"> ${match.homeTeam}</span>
		   		<span class="score"> ${match.homeScore}</span>
		   	</div>
		   	<div>
		   		<span class="team_name">${match.awayTeam}</span>
		   		<span class="score"> ${match.awayScore}</span>
		   	</div>
		   	
		   		<input type="hidden" name="match_id" value="${match.ID}" /> 	
	   	</div>	
	   		
	</c:forEach>
	
	
</div>


<div>
	<form method="post" action="/demowebapp/plapp/admin">
		<input type="submit" value="Admin">
	</form>
</div>


</body>
</html>