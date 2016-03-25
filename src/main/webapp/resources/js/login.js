jQuery(document).ready(function($) {
	
	if($('.login-page-error').length){
		$.getScript("resources/js/notie.js").done(function( script, textStatus ) {
			notie.alert(3, $('.login-page-error').html(), 3);	
		 });
	}
	
	if($('.login-page-logout').length){
		$.getScript("resources/js/notie.js").done(function( script, textStatus ) {
			notie.alert(4, $('.login-page-logout').html(), 3);	
		 });
	}
	
});