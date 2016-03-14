<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<div class="list-group-item">
	
	<h3 class="heading">
		Highscore
	</h3>
	
	
	<div class="wrapper col-lg-6">
		<div class="total-score score-section">
			<h4>
				Total:
			</h4>
		
			<table>
				<c:forEach items="${totalHighscore}" var="entry">
					<tr class="highscore-entry matches-all">
						<td><span>${entry.user.username}</span> </td> 
						<td><span class="value">${entry.score}</span></td>
						<input class="hidden-id" type="hidden" value="${entry.user.ID}">
						<input class="hidden-username" type="hidden" value="${entry.user.username}">
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


	<div class="wrapper col-lg-6">
		<div class="round-score score-section">
			<h4>
				Round:
			</h4>
			<table>
				<c:forEach items="${roundHighscore}" var="entry">
					<tr class="highscore-entry matches-round">
						<td><span>${entry.user.username}</span> </td> 
						<td><span class="value">${entry.score}</span></td>
						<input class="hidden-id" type="hidden" value="${entry.user.ID}">
						<input class="hidden-username" type="hidden" value="${entry.user.username}">
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
</div>