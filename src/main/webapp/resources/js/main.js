jQuery(document).ready(function($) {

	
	$( ".btn.bet" ).click(function(event) {
		
		var target = $( event.target );
		
		var match_id = target.parent(".list-group-item").find("form").submit();
	
	});
	
	$( ".round button" ).click(function(event) {
		
		$("#pagination_form").submit();
		
	});
	
});