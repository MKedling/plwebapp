<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<div class="list-group-item matches">
			
	<div>
		<span>${match.starttime}</span>
		<br>
		<span>Round: ${match.round}</span>
	</div>
	
	<c:if test="${matchType eq 'matchToBet'}" >
		<form method="POST" action="/plapp/plapp/home/bet">
			<div>
		   		<span class="team_name"> ${match.homeTeam}</span>
		   		<span class="plus_minus home_team" data-name="score_home" data-value="0" data-id="1"></span>
		   	</div>
		   	<div>
		   		<span class="team_name">${match.awayTeam}</span>
		   		<span class="plus_minus away_team" data-name="score_away" data-value="0" data-id="1"></span>
		   	</div>
		   	
		   	<input type="hidden" name="match_id" value="${match.ID}" />
		   	<input type="hidden" name="round" value="${match.round}" />  
	   	</form>
	   	
	   	<button type="button" class="btn btn-primary bet" value="">PLACERA BET</button> 
   	</c:if>	
   	
   	<c:if test="${matchType eq 'matchBetExist'}" >
		<div>
	   		<span class="team_name"> ${match.homeTeam}</span>
	   		<span class="score"> ${match.betHomeScore}</span>
	   	</div>
	   	<div>
	   		<span class="team_name">${match.awayTeam}</span>
	   		<span class="score"> ${match.betAwayScore}</span>
	   	</div> 
   	</c:if>	
   	
   	<c:if test="${matchType eq 'matchToAddResult'}" >
	   	<form method="POST" action="/plapp/plapp/login/admin/addResult">
			<div>
		   		<span class="team_name"> ${match.homeTeam}</span>
		   		<span class="plus_minus home_team" data-name="score_home" data-value="0" data-id="1"></span>
		   	</div>
		   	<div>
		   		<span class="team_name">${match.awayTeam}</span>
		   		<span class="plus_minus away_team" data-name="score_away" data-value="0" data-id="1"></span>
		   	</div>
		   	
		   	<input type="hidden" name="match_id" value="${match.ID}" /> 
	   	</form>
	   	
	   	<button type="button" class="btn btn-primary bet" value="">LÄGG TILL</button> 
	 </c:if>
		   		
</div>	