/* -------------------- Retina Displays Support --------------------- */
function isRetina() {
	var query = '(-webkit-min-device-pixel-ratio: 1.5),\
				(min--moz-device-pixel-ratio: 1.5),\
				(-o-min-device-pixel-ratio: 3/2),\
				(min-device-pixel-ratio: 1.5),\
				(min-resolution: 144dpi),\
				(min-resolution: 1.5dppx)';

	if (window.devicePixelRatio > 1 || (window.matchMedia && window.matchMedia(query).matches)) {
		return true;
	}

	return false;
}

// Check if High Res image exist
function checkIndex(file){
		
      $.ajax({
          url: file,
          type:'HEAD',
          async: false,
          error: function(){
                return false;		
          },
          success: function(){
                return true;
          }
      });
}

// Replace images with @2x
jQuery(document).ready(function($) {
	if (window.isRetina()) {
		var images = document.getElementsByClassName('img-retina');
		for (var i = 0, j = images.length; i < j; i++) {
			var image = images[i],
				src = image.src,
				width = image.width,
				height = image.height,
				lastSlash = src.lastIndexOf('/'),
				path = src.substring(0, lastSlash),
				file = src.substring(lastSlash + 1),
				retinaSrc = 'img/@2x/' + file;
				
				$.ajax({
			          url: retinaSrc,
			          type:'HEAD',
			          async: false,
			          error: function(){
			                //no retina images
			          },
			          success: function(){
			                image.src = retinaSrc;
							image.width = width;
							image.height = height;
			          }
			      });
				
		}
	}
});

/* -------------------- Fixed Menu --------------------- */
$(window).scroll(function($){
	fixedMenu();			
});

function fixedMenu() {
	
	var fromTop = $(window).scrollTop();
	var browserHeight = $(window).height();
	var bodyHeight = $('body').height();
	var fromBottom = bodyHeight - ($('footer').height() + $('#copyright').height());
	
	
	if (fromTop > 80 && fromTop + browserHeight < fromBottom) {
		
		$('#fixed-menu').css('bottom','0px');
		
	} else {
		
		$('#fixed-menu').css('bottom','-40px');
		
	} 
	
}

/* -------------------- Contact Form Background Map --------------------- */
jQuery(document).ready(function($) {
	
	if($('#map').html()) {
		
		var target = $('#map').html();

		$('#map').gMap({
			controls: {
				panControl: false,
				zoomControl: false,
				mapTypeControl: false,
				scaleControl: false,
				streetViewControl: false,
				overviewMapControl: false
			},
			maptype: 'ROADMAP',
			scrollwheel: false,
			zoom: 13,
			markers: [
				{
					address: target, // Your Adress Here
					html: '',
					popup: false,
				}

			],

		});
	}

});

/* -------------------- Placeholder for IE --------------------- */
jQuery(document).ready(function($) {

	// Invoke the plugin
    $('input, textarea').placeholder();
    // That’s it, really.
    // Now display a message if the browser supports placeholder natively
    var html;
    
});

/* -------------------- Overlay Images --------------------- */
jQuery(document).ready(function($){
	
	if((navigator.userAgent.match(/iPhone/i)) || (navigator.userAgent.match(/iPod/i)) || (navigator.userAgent.match(/iPad/i))) {
	    
		$('.project > .picture').click(function(){
			
			$('.project > .picture').each(function(){
				$(this).find('.overlay').fadeOut().parent().find('.search').animate({marginLeft: '0px'},100);
				$(this).find('.overlay').fadeOut().parent().find('.link').animate({marginRight: '0px'},100);
			});
			
	        $(this).find('.overlay').fadeIn().parent().find('.search').animate({marginLeft: '48%'},100);
			$(this).find('.overlay').fadeIn().parent().find('.link').animate({marginRight: '48%'},100);
	    });
		
		$('.item > .picture').click(function(){
			
			$('.item > .picture').each(function(){
				$(this).find('.overlay').animate({opacity: 0, marginTop:'100%'},250);
			});
			
	        $(this).find('.overlay').animate({opacity: 1, marginTop:'0%'},250);
	    });
	
	} else {
		
		$('.project > .picture').hover(

			function(){
			    $(this).find('.overlay').fadeIn().parent().find('.search').animate({marginLeft: '48%'},100);
				$(this).find('.overlay').fadeIn().parent().find('.link').animate({marginRight: '48%'},100);
			  },
			function(){
			    $(this).find('.overlay').fadeOut().parent().find('.search').animate({marginLeft: '0px'},100);
				$(this).find('.overlay').fadeOut().parent().find('.link').animate({marginRight: '0px'},100);
			}

		);

		$('.item > .picture').hover(

			function(){
			    $(this).find('.overlay').animate({opacity: 1, marginTop:'0%'},250);
			  },
			function(){
			    $(this).find('.overlay').animate({opacity: 0, marginTop:'100%'},250);
			}

		);
		
	}
	
});

/* -------------------- Accordion --------------------- */
jQuery(document).ready(function($){

    $('.accordion').on('show', function (e) {
         $(e.target).prev('.accordion-heading').find('.accordion-toggle').addClass('active');
		 $(e.target).prev('.accordion-heading').find('.accordion-toggle i').removeClass('icon-plus');
		$(e.target).prev('.accordion-heading').find('.accordion-toggle i').addClass('icon-minus');
    });
    
    $('.accordion').on('hide', function (e) {
        $(this).find('.accordion-toggle').not($(e.target)).removeClass('active');
		$(this).find('.accordion-toggle i').not($(e.target)).removeClass('icon-minus');
		$(this).find('.accordion-toggle i').not($(e.target)).addClass('icon-plus');
    });
        
});

/* -------------------- Twitter --------------------- */
jQuery(document).ready(function($){
		
	$.getJSON('./twitter.php?url='+encodeURIComponent('statuses/user_timeline.json?screen_name=bootstrapmaster&count=10&include_rts=false&exclude_replies=true'), 
	
	function(tweets){
		$("#twitter > .slides").html(tz_format_twitter(tweets));
	});
	
});

$(window).load(function(){
	
	var $carrousel = $('#twitter');
	
	$carrousel.flexslider({
	    animation: "slide",
		direction: "vertical",
		easing: "swing",
	    animationLoop: true,
	    minItems: 1,
	    maxItems: 1,
		controlNav: false,
		directionNav: true,
		move: 1
     });

	$("#twitter-nav > a").click(function(event) {

		event.preventDefault();

	});

	$('#tweet-next').click(function(){
		$carrousel.flexslider("next");
	});

	$('#tweet-prev').click(function(){
		$carrousel.flexslider("prev");
	});
	
});

/* ------------------- Fancybox --------------------- */
jQuery(document).ready(function($){
	
	$('.fancybox').fancybox({
		type        : 'image',
		openEffect  : 'fade',
		closeEffect	: 'fade',
		nextEffect  : 'fade',
		prevEffect  : 'fade',
		helpers     : {
			title   : {
				type : 'inside'
			}
		}
	});
	
});

/* ------------------ Scroll To Section ------------------- */

jQuery(document).ready(function($){

	$('.scroll-nav > li > a').click(function(){
		
		var target = $(this).attr('href');
		
		if($(this).hasClass('back-to-top')) {
			
			//back to top if using scroll menu
			$('html, body').animate({scrollTop:0}, 300); 
			return false;
			
		} else if ($(this).hasClass('scroll')) {
			
			$('html, body').animate({
				scrollTop: $(target).offset().top
			}, 300);
			return false;
			
		} else {
			
			//do nothing
			
		}
							
	});
	
});
	
/* ------------------ Back To Top ------------------- */
jQuery(document).ready(function($){

	jQuery('.back-to-top').click(function(){
		jQuery('html, body').animate({scrollTop:0}, 300); 
		return false; 
	});

});	

/* ------------------ Tooltips ----------------- */
jQuery(document).ready(function($) {

    $('.tooltips').tooltip({
      selector: "a[rel=tooltip]"
    })

});

/* ------------------ Progress Bar ------------------- */	
jQuery(document).ready(function($){
	
	$('.meter > span').each(function() {
		
		var totalWidth = $(this).parent().width();
		
		var barWidth = $(this).width();
		
		var percent = barWidth/totalWidth * 100;

		$(this).data('origWidth', $(this).width()).width(0).animate({
			width: $(this).data('origWidth')
		}, 1200, function(){
			$(this).css('width', percent + '%');
		});

		
	});
});


/* -------------------- Isotope --------------------- */
jQuery(document).ready(function () {
	
	$('#wall').imagesLoaded(function() {
		
		var $container = $('#wall');
			$select = $('#filters select');

		// initialize Isotope
		$container.isotope({
		// options...
		resizable: false, // disable normal resizing
		// set columnWidth to a percentage of container width
	  	masonry: { columnWidth: $container.width() / 12 }
		});

		// update columnWidth on window resize
		$(window).smartresize(function(){
		
			$container.isotope({
			// update columnWidth to a percentage of container width
				masonry: { columnWidth: $container.width() / 12 }
			});
		});


		$container.isotope({
			itemSelector : '.item'
		});

		$select.change(function() {
			
			var filters = $(this).val();

				$container.isotope({
					filter: filters
				});
			
			});

			var $optionSets = $('#filters .option-set'),
		  	$optionLinks = $optionSets.find('a');

		  	$optionLinks.click(function(){
			
				var $this = $(this);
				// don't proceed if already selected
				if ( $this.hasClass('selected') ) {
			  		return false;
				}
			var $optionSet = $this.parents('.option-set');
			$optionSet.find('.selected').removeClass('selected');
			$this.addClass('selected');

			// make option object dynamically, i.e. { filter: '.my-filter-class' }
			var options = {},
				key = $optionSet.attr('data-option-key'),
				value = $this.attr('data-option-value');
			// parse 'false' as false boolean
			value = value === 'false' ? false : value;
			options[ key ] = value;
			if ( key === 'layoutMode' && typeof changeLayoutMode === 'function' ) {
			  // changes in layout modes need extra logic
			  changeLayoutMode( $this, options )
			} else {
			  // otherwise, apply new options
			  $container.isotope( options );
			}

			return false;
			
		  });
		
	});
	
});

/* ----------------- Contact Form ------------------- */		
jQuery(document).ready(function($){
		
	var animateSpeed=100;
	var emailReg = /^[a-zA-Z0-9._-]+@([a-zA-Z0-9.-]+\.)+[a-zA-Z0-9.-]{2,4}$/;

	// Validating

	function validateName(name) {
	
		if (name.val().length < 2) {name.addClass('validation-error',animateSpeed); return false;}
		else {name.removeClass('validation-error',animateSpeed); return true;}
	
	}

	function validateEmail(email,regex) {
				
		if (!regex.test(email.val())) {email.addClass('validation-error',animateSpeed); return false;}
		else {email.removeClass('validation-error',animateSpeed); return true;}
	
	}

	function validateMessage(message) {
		
		if (message.val()=='') {message.addClass('validation-error',animateSpeed); return false;}
		else {message.removeClass('validation-error',animateSpeed); return true;}
	
	}

	$('input[name=name]').blur(function(){validateName($(this));});
	$('input[name=email]').blur(function(){validateEmail($(this),emailReg); });
	$('textarea[name=message]').blur(function(){validateMessage($(this)); });

});

jQuery(document).ready(function($){

	$('.send').click(function(){

		$.post("contactForm.php", { 

			new_message: 1,
			name: $('input[name=name]').val(),
			message_email: $('input[name=email]').val(),
			www: $('input[name=www]').val(),
			message: $('textarea[name=message]').val()

		}, function(data) {

			if(data==1) {

				alert('Message was sent');

			} else {

				alert('Ooops something goes wrong, try one more time!');

			}

		});
		
		return false;

	});

});

/* ------------------- Layered slider --------------------- */
jQuery(document).ready(function($){
	
	$('#layerslider-main').layerSlider({
		imgPreload : true,
		skinsPath : 'css/skins/',
		skin : 'one',
		thumbnailNavigation : 'hidden',				
	});				
	
});

/* -------------------- Width Functions --------------------- */
jQuery(document).ready(function($){
	
	widthFunctions();

});

$(window).bind("resize", widthFunctions);

function widthFunctions(e) {
	
    var winHeight = $(window).height();
    var winWidth = $(window).width();
    
	if (winWidth < 980 && winWidth > 767) {
		
		if($(".lr-page").hasClass("span4 offset4")) {
			
			$(".lr-page").removeClass("span4 offset4");
			$(".lr-page").addClass("span6 offset3");

		}
		
		if($(".contact-info").hasClass("span8 offset2")) {
			
			$(".contact-info").removeClass("span8 offset2");
			$(".contact-info").addClass("span10 offset1");

		}
						
	} else {
				
		if($(".lr-page").hasClass("span6 offset3")) {
			
			$(".lr-page").removeClass("span6 offset3");
			$(".lr-page").addClass("span4 offset4");

		}
		
		if($(".contact-info").hasClass("span10 offset1")) {
			
			$(".contact-info").removeClass("span10 offset1");
			$(".contact-info").addClass("span8 offset2");

		}
			
	}
	
}