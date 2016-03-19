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
  			<!-- 
  			<th>
  				Points
  			</th>
  			 -->
  		</tr>

	<c:forEach items="${allCompletedBets}" var="bet">
	
		<c:choose>
		  <c:when test="${bet.betScore eq 2}">
		    <tr class="two-points">
		  </c:when>
		  <c:when test="${bet.betScore eq 1}">
		  	<tr class="one-points">
		  </c:when>
		  <c:otherwise>
		    <tr class="zero-points">
		  </c:otherwise>
		</c:choose>
	
   			<td class="round"> ${bet.round}</td>
   			<td class="completed-team_name"> ${bet.homeTeam} - ${bet.awayTeam}</td>
   			<td class="completed-bet-score"> ${bet.betHomeScore} - ${bet.betAwayScore}</td>
   			<td class="completed-correct-score"> ${bet.matchHomeScore} - ${bet.matchAwayScore}</td>
   			<!--  <td class="completed-point"> ${bet.betScore}</td> -->
   		</tr>
	</c:forEach>
  		
 </table>
		 

