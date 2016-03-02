<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<table class="table table-striped">
  		<tr>
  			<th>
  				#
  			</th>
  			<th>
  				Team
  			</th>
  			<th>
  				Bet score
  			</th>
  			<th>
  				Correct score
  			</th>
  		</tr>

	<c:forEach items="${allCompletedBetsRound}" var="bet">
   		<tr>
   			<td class="round"> ${bet.round}</td>
   			<td class="completed_team_name"> ${bet.homeTeam} - ${bet.awayTeam}</td>
   			<td class="completed_score"> ${bet.betHomeScore} - ${bet.betAwayScore}</td>
   			<td class="completed_score correct-score"> ${bet.matchHomeScore} - ${bet.matchAwayScore}</td>
   		</tr>
	</c:forEach>
  		
 </table>
		 

