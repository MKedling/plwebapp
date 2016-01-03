<body>

<div>
	${userSession.user.username}
</div>



<div class="list-group">
	<div class="pagination">
		<span class="plus_minus" data-name="quantity" data-value="0" data-id="10"></span>
	</div>
	<c:forEach items="${matches}" var="match">
		
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
	   		
	   	<input type="hidden" value="${match.ID}">
	   	
	   	 
	</c:forEach>
</div>


<div>
	<form method="post" action="/demowebapp/plapp/admin">
		<input type="submit" value="Admin">
	</form>
</div>

<div>
	<c:forEach items="${bets}" var="bet">
		${bet.ID}
	</c:forEach>
</div>

	
</body>