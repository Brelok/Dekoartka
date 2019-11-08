$(function () {

    var button = $('#button'); //submit button

    button.css('background', '#A27157');

/* read more/less - start */
    var articles = $('.article'); //articles
    var maxChar = 300

    articles.each(function () {
        if ($(this).html().toString().length > maxChar) {

            var button = $(this).siblings('.buttonsMore');
            button.css('display', 'block');

            var height = $(this).height();
            $(this).css('height', '210px');

            button.on('click', function () {
                if ($(this).hasClass('buttonsLess')) {
                    $(this).removeClass('buttonsLess');
                    $(this).html("Czytaj więcej");
                    $(this).siblings('.article').animate({height: '210px'}, 1000);

                } else {
                    $(this).addClass('buttonsLess');
                    $(this).html("Czytaj mniej");
                    $(this).siblings('.article').animate({height: height}, 1000);
                }
            })
        }
    })
    /* read more/less - end */

    var menu = $('.menu');
    menu.css('position', 'fixed');


});