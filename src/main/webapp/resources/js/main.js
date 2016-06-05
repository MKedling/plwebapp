var webContext = '/em/';
var getAllBetsUrl =  webContext + 'home/getCorrectedBetsAll';
var getRoundBetsUrl = webContext + 'home/getStartedBetsRound';
var getBetsRoundUrl = webContext + 'home/getBetsRound';
var popupLocator = '#popup';
var loggedInUserID = $(".logged-in-userID").val();

jQuery(document).ready(function($) {
	
	$( "#pagination_form button" ).click(function(event) {
		
		$("#pagination_form").submit();
		
	});
	
	
	$( "tr.highscore-entry" ).click(function(event) {
		
		if($(this).hasClass("matches-all")){
			getBetsAndShowInPopup(getAllBetsUrl, this);
		}else if($(this).hasClass("matches-round")){
			getBetsAndShowInPopup(getRoundBetsUrl, this);
		}
		
		$(popupLocator).modal('show');
	
	});
	
	function getBetsAndShowInPopup(url, element) {
		var id = $(element).children("input.hidden-id").val();
		var username = $(element).children("input.hidden-username").val();
		var roundToView = $("#roundToView").attr("data-value");
		
		$.get( url , {userID : id, round : roundToView}).done(function( data ) {
			  $( ".popup-content" ).html( data );
		});     
		
		$(".modal-title").html(username);
	}
	
	function getBetsAndShowInAsRoundBets() {
		var roundToView = $(".round-to-view").val();
		$.get( getBetsRoundUrl , {round : roundToView}).done(function( data ) {
			  $( ".betted-matches" ).html( data );
		});
	}

	$( ".test-ajax" ).click(function(event) {
	
		var submitButton = $(this);
		var score_home = $(this).siblings("form").find(".home_team .input-number").val();
		var score_away = $(this).siblings("form").find(".away_team .input-number").val();
		var round = $(this).siblings("form").find("input[name='round']").val()
		var match_id = $(this).siblings("form").find("input[name='match_id']").val()
		
		$.ajax({
			   url: 'home/ajaxBet',
			   data: {
				   "match_id" : match_id,
				   "score_home" : score_home,
				   "score_away" : score_away,
				   "round" : round
			   },
			   error: function() {
			      notie.alert(3, 'Could not be placed', 1.5);
			      
			   },
			   success: function(data) {
			      $(submitButton).closest(".list-group-item.matches").slideUp("slow");
			      getBetsAndShowInAsRoundBets();
			      notie.alert(1, 'Bet placed!', 1.5);
			   },
			   type: 'POST'
		});
	
	});
	
	getBetsAndShowInAsRoundBets();
	
});