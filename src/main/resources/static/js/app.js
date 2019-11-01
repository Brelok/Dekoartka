$(function () {

    var button = $('#button'); //submit button

    button.css('background', '#A27157');

    button.on('submit', function () {
        console.log("wiadomość wysłana")
    })
})