<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container main-content">
		<div class="row">
		
		<div class="navbar-header col-xs-12">
		
				<div class="wrapper col-xs-4">
					<a class="navbar-brand" href="/plapp/home">${userSession.user.username}</a>
				</div>
				
				<div class="wrapper col-xs-4 show-round">
					<div class="pagination">
						<form id="pagination_form" method="POST"
							action="/plapp/home">
							<span id="roundToView" class="plus_minus" data-name="quantity"
								data-value="${roundToView}" data-id="101"></span>
						</form>
					</div>
				</div>
				
				<div class="wrapper col-xs-4 col-xs-offset-5">
					<div class="summary">
						<table>
							<tr>
								<td>
									<span class="key">Current round:</span>
									<span class="value">${currentRound}</span>
								</td>
							</tr>
							<tr>   
								<td>
									<span class="key">Total Score: </span>
									<span class="value">${scoreTotal}</span>
								</td>
							</tr>
						</table>
					</div>
				</div>
				
			</div>
			
		</div>
	</div>
</nav>