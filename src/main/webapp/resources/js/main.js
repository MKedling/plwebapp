jQuery(document).ready(function($) {

	
	$( ".btn.bet" ).click(function(event) {
		
		var target = $( event.target );
		
		var match_id = target.parent(".list-group-item").find("input[type=hidden]").val();
		var score_home = target.parent(".list-group-item").find('input[name^=score_home]').val();
		var score_away = target.parent(".list-group-item").find('input[name^=score_away]').val();
		
		
		$.post( "bet", { match_id: match_id, home_team_score : score_home, away_team_score : score_away } , function() {
			    
			  
		})
	});
	
	
	
});