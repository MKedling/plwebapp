var webContext = '/plapp/plapp/';
var getAllBetsUrl =  webContext + 'home/getCorrectedBetsAll';
var getRoundBetsUrl = webContext + 'home/getStartedBetsRound';
var popupLocator = '#popup';

jQuery(document).ready(function($) {
	
	$( ".btn.bet" ).click(function(event) {
		
		var target = $( event.target );
		
		var match_id = target.parent(".list-group-item").find("form").submit();
	
	});
	
	$( "#pagination_form button" ).click(function(event) {
		
		$("#pagination_form").submit();
		
	});
	
	
	
	$( "tr.highscore-entry" ).click(function(event) {
		
		if($(this).hasClass("matches-all")){
			getBetsAndShow(getAllBetsUrl, this);
		}else if($(this).hasClass("matches-round")){
			getBetsAndShow(getRoundBetsUrl, this);
		}
		
		$(popupLocator).modal('show');
	
	});
	
	function getBetsAndShow(url, element, title) {
		var id = $(element).children("input.hidden-id").val();
		var username = $(element).children("input.hidden-username").val();
		var roundToView = $("#roundToView").attr("data-value");
		
		$.get( url , {userID : id, round : roundToView}).done(function( data ) {
			  $( ".popup-content" ).html( data );
		});     
		
		$(".modal-title").html(username);
	}
	
	

});