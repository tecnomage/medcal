var jumboHeight = $('.jumbotron').outerHeight();
function parallax(){
    var scrolled = $(window).scrollTop();
    $('.bg').css('height', (jumboHeight-scrolled) + 'px');
}


$(window).scroll(function(e){
	 parallax();
});


function alerta() {
	alert("Hello! I am an alert box!!");
	
}