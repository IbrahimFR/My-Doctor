/* Demo Scripts for Bootstrap Carousel and Animate.css article
 * on SitePoint by Maria Antonietta Perna
 */
(function ($) {

    //Function to animate slider captions
    function doAnimations(elems) {
        //Cache the animationend event in a variable
        var animEndEv = 'webkitAnimationEnd animationend';

        elems.each(function () {
            var $this = $(this),
                $animationType = $this.data('animation');
            $this.addClass($animationType).one(animEndEv, function () {
                $this.removeClass($animationType);
            });
        });
    }

    //Variables on page load
    var $myCarousel = $('#carousel-example-generic'),
        $firstAnimatingElems = $myCarousel.find('.item:first').find("[data-animation ^= 'animated']");

    //Initialize carousel
    $myCarousel.carousel();

    //Animate captions in first slide on page load
    doAnimations($firstAnimatingElems);

    //Pause carousel
    $myCarousel.carousel('pause');


    //Other slides to be animated on carousel slide event
    $myCarousel.on('slide.bs.carousel', function (e) {
        var $animatingElems = $(e.relatedTarget).find("[data-animation ^= 'animated']");
        doAnimations($animatingElems);
    });

})(jQuery);


$(document).ready(function () {
    $('.carousel').carousel({
        interval: 6000
    });
});


//////////////////////////


var Main__firstName = document.getElementById('Main__firstName');
var Main__lastName = document.getElementById('Main__lastName');
var Main__email = document.getElementById('Main__email');
var Main__message = document.getElementById('Main__message');


var Main__right_mark_FirstName = document.getElementById('Main_right_mark_FirstName');
var Main__right_mark_LastName = document.getElementById('Main_right_mark_LastName');
var Main__right_mark_Email = document.getElementById('Main_right_mark_Email');
var Main__right_mark_message = document.getElementById('Main_right_mark_message');


function Main_userFirstNameVaildation() {
    if (!Main__firstName.value.match(/^[a-zA-Z]{2,50}$/)) {
        Main__firstName.style.border = '2px solid #ff1703'; // red

        $(Main__right_mark_FirstName).addClass('hidden');
        return true;
    }
    else {
        Main__firstName.style.border = '1px solid #E3E3E3';

        $(Main__right_mark_FirstName).removeClass('hidden');
        return false;
    }
}


function Main_userLastNameVaildation() {
    if (!Main__lastName.value.match(/^[a-zA-Z]{2,50}$/)) {
        Main__lastName.style.border = '2px solid #ff1703';
        $(Main__right_mark_LastName).addClass('hidden');
        return true;
    }
    else {
        Main__lastName.style.border = '1px solid #E3E3E3';
        $(Main__right_mark_LastName).removeClass('hidden');
        return false;
    }
}


function Main_userEmailVaildation() {
    if (!Main__email.value.match(/^[A-Za-z0-9/._/]{2,40}[@][A-Za-z]{2,9}[/.][A-Za-z]{2,9}$/)) {
        Main__email.style.border = '2px solid #ff1703';


        $(Main__right_mark_Email).addClass('hidden');
        return true;
    }
    else {
        Main__email.style.border = '1px solid #E3E3E3';

        $(Main__right_mark_Email).removeClass('hidden');
        return false;
    }
}


function Main_userMessageVaildation() {
    if (!Main__message.value.match(/^[a-zA-Z0-9\s]{6,1000}$/)) {
        Main__message.style.border = '2px solid #ff1703';


        $(Main__right_mark_message).addClass('hidden');
        return true;
    }
    else {
        Main__message.style.border = '1px solid #E3E3E3';

        $(Main__right_mark_message).removeClass('hidden');
        return false;
    }
}

function Main_RuserFirstNameVaildation() {

    $(Main__right_mark_FirstName).addClass('hidden');

}


function Main_RuserLastNameVaildation() {

    $(Main__right_mark_LastName).addClass('hidden');

}


function Main_RuserEmailVaildation() {
    $(Main__right_mark_Email).addClass('hidden');

}


function Main_RuserMessageVaildation() {


    $(Main__right_mark_message).addClass('hidden');

}


function Main_user_form_Valid() {

    if (Main_userFirstNameVaildation() || Main_userLastNameVaildation()
        || Main_userEmailVaildation() || Main_userMessageVaildation()) {

        Main_userFirstNameVaildation();
        Main_userLastNameVaildation();
        Main_userEmailVaildation();
        Main_userMessageVaildation();
        return false;
    }
    else {
        return true;
    }


}