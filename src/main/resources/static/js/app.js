$(function () {

    var button = $('#button'); //submit button

    button.css('background', '#A27157');

    var buttonsFromBlog = $('.buttonsMore'); // buttony read less/more

    var articles = $('p.mb-3'); //articles

    var firstArticle = $('p.first');


    if (firstArticle.value.length >= 500) {
        firstArticle.css('color', 'red');
    }

});