var jumboHeight = $('.jumbotron').outerHeight();
function parallax(){
    var scrolled = $(window).scrollTop();
    $('.bg').css('height', (jumboHeight-scrolled) + 'px');
}

on.load(alert("Hello! I am an alert box!!"));

$(window).scroll(function(e){
	 parallax();
});